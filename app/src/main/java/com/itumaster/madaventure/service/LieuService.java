package com.itumaster.madaventure.service;

import com.google.gson.reflect.TypeToken;
import com.itumaster.madaventure.model.ApiResponse;
import com.itumaster.madaventure.model.Lieu;
import com.itumaster.madaventure.model.minterface.ApiResponseListener;
import com.itumaster.madaventure.util.NetworkUtils;

import java.util.List;

public class LieuService {
    private static final String BASE_URL = "https://backend-madaventure-production.up.railway.app/api/v1/lieu/";
    private static final String TAG = "Lieu Service";

    public static void findLieu(String word, final ApiResponseListener<List<Lieu>> listener) {
        String url = "search?word=" + word;
//        NetworkUtils.performGetRequestAsync(BASE_URL + url, new NetworkUtils.NetworkCallback() {
//            @Override
//            public void onSuccess(String response) {
//                ApiResponse<List<Lieu>> apiResponse = ApiResponse.fromJson(response, new TypeToken<List<Lieu>>() {}.getType());
//                if (apiResponse.isSuccess()) {
//                    List<Lieu> lieux = apiResponse.getData();
//                    listener.onSuccess(lieux);
//                } else {
//                    listener.onError(apiResponse.getMessage());
//                }
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//                listener.onError(errorMessage);
//            }
//        });
    }

    public static void addLieu(Lieu lieu, final ApiResponseListener<Lieu> listener) {
        String url = "add";
        String jsonBody = lieu.toJson();
        NetworkUtils.performPostRequestAsync(BASE_URL + url, jsonBody, new NetworkUtils.NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                ApiResponse<Lieu> apiResponse = ApiResponse.fromJson(response, Lieu.class);
                if (apiResponse.isSuccess()) {
                    Lieu addedLieu = apiResponse.getData();
                    listener.onSuccess(addedLieu);
                } else {
                    listener.onError(apiResponse.getMessage());
                }
            }

            @Override
            public void onError(String errorMessage) {
                listener.onError(errorMessage);
            }
        });
    }
}
