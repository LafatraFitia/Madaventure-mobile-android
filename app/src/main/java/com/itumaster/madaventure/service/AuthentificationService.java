package com.itumaster.madaventure.service;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.itumaster.madaventure.model.ApiResponse;
import com.itumaster.madaventure.model.Utilisateur;
import com.itumaster.madaventure.model.minterface.ApiResponseListener;
import com.itumaster.madaventure.util.NetworkUtils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class AuthentificationService {
    private static final String BASE_URL = "https://backend-madaventure-production.up.railway.app/api/v1/user/";
    private static final String TAG = "Authentificatio Service";

    public static void login(Utilisateur utilisateur, final ApiResponseListener<Utilisateur> listener) {
        String url = "login";
        String jsonBody = utilisateur.toJsonNonNull();
        Log.d(TAG, "login: "+jsonBody);
        Log.d(TAG, "login all: "+utilisateur.toJson());
        NetworkUtils.performPostRequestAsync(BASE_URL + url, jsonBody, new NetworkUtils.NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Log.d(TAG, "Response: " + response);
                Type userType = new TypeToken<Utilisateur>() {}.getType();
                ApiResponse<Utilisateur> apiResponse = ApiResponse.fromJson(response, userType);
                if (apiResponse != null && apiResponse.isSuccess() ) {
                    if (apiResponse.hasData()) {
                        Utilisateur loggedInUser = apiResponse.getData();

                        // Exécution sur le thread principal
                        new Handler(Looper.getMainLooper()).post(() -> {
                            listener.onSuccess(loggedInUser);
                        });
                    } else {
                        new Handler(Looper.getMainLooper()).post(() -> {
                            String messageErr = "Nous ne parvenons pas à retrouver votre compte," +
                                    " veuillez réessayer dans quelques instants.";
                            listener.onError(messageErr);
                        });
                    }

                } else {
                    // Exécution sur le thread principal
                    new Handler(Looper.getMainLooper()).post(() -> {
                        listener.onError(apiResponse.getMessage());
                    });
                }
            }

            @Override
            public void onError(String errorMessage) {
                // Exécution sur le thread principal
                new Handler(Looper.getMainLooper()).post(() -> {
                    listener.onError(errorMessage);
                });
            }
        });
    }

    public static void inscription(Utilisateur utilisateur, final ApiResponseListener<Utilisateur> listener) {
        String url = "inscription";
        String jsonBody = utilisateur.toJson();

        NetworkUtils.performPostRequestAsync(BASE_URL + url, jsonBody, new NetworkUtils.NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Log.d("Inscription", "Response: " + response);
                Type userType = new TypeToken<Utilisateur>() {}.getType();
                ApiResponse<Utilisateur> apiResponse = ApiResponse.fromJson(response, userType);
                if (apiResponse.isSuccess()) {
                    Utilisateur registeredUser = apiResponse.getData();
                    listener.onSuccess(registeredUser);
                } else {
                    listener.onError(apiResponse.getMessage());
                }
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("Inscription", "Response: " + errorMessage);
                listener.onError(errorMessage);
            }
        });
    }
}
