package com.itumaster.madaventure.util;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.itumaster.madaventure.model.ApiResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NetworkUtils {

    private static final OkHttpClient client = new OkHttpClient();

    public interface NetworkCallback {
        void onSuccess(String response);
        void onError(String errorMessage);
    }

    public static void performGetRequestAsync(String url, NetworkCallback callback) {
        AsyncTask.execute(() -> {
            try {
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    callback.onSuccess(responseData);
                } else {
                    ResponseBody resp = response.body();
                    if (resp != null) {
                        String bodystr = resp.string();
                        JSONObject obj = new JSONObject(bodystr);
                        if (obj.has("message")) {
                            callback.onError(obj.getString("message"));
                        } else {
                            callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
                        }

                    } else {
                        callback.onError("Requete échoué. Veuillez reessayer plus tard.");
                    }

                }
            } catch (IOException | JSONException e) {
                callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
            }
        });
    }

    public static void performPostRequestAsync(String url, String jsonBody, NetworkCallback callback) {
        AsyncTask.execute(() -> {
            try {
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = RequestBody.create(jsonBody, mediaType);

                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();

                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    callback.onSuccess(responseData);
                } else {
                    ResponseBody resp = response.body();
                    if (resp != null) {
                        String bodystr = resp.string();
                        JSONObject obj = new JSONObject(bodystr);
                        if (obj.has("message")) {
                            callback.onError(obj.getString("message"));
                        } else {
                            callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
                        }

                    } else {
                        callback.onError("Requete échoué. Veuillez reessayer plus tard.");
                    }

                }
            } catch (IOException | JSONException e) {
                callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
            }
        });
    }

    public static void performPutRequestAsync(String url, String jsonBody, NetworkCallback callback) {
        AsyncTask.execute(() -> {
            try {
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = RequestBody.create(jsonBody, mediaType);

                Request request = new Request.Builder()
                        .url(url)
                        .put(requestBody)
                        .build();

                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    callback.onSuccess(responseData);
                } else {
                    ResponseBody resp = response.body();
                    if (resp != null) {
                        String bodystr = resp.string();
                        JSONObject obj = new JSONObject(bodystr);
                        if (obj.has("message")) {
                            callback.onError(obj.getString("message"));
                        } else {
                            callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
                        }

                    } else {
                        callback.onError("Requete échoué. Veuillez reessayer plus tard.");
                    }

                }
            } catch (IOException | JSONException e) {
                callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
            }
        });
    }

    public static void performDeleteRequestAsync(String url, NetworkCallback callback) {
        AsyncTask.execute(() -> {
            try {
                Request request = new Request.Builder()
                        .url(url)
                        .delete()
                        .build();

                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    callback.onSuccess(responseData);
                } else {
                    ResponseBody resp = response.body();
                    if (resp != null) {
                        String bodystr = resp.string();
                        JSONObject obj = new JSONObject(bodystr);
                        if (obj.has("message")) {
                            callback.onError(obj.getString("message"));
                        } else {
                            callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
                        }

                    } else {
                        callback.onError("Requete échoué. Veuillez reessayer plus tard.");
                    }

                }
            } catch (IOException | JSONException e) {
                callback.onError("Un erreur s'est produite, veuillez reessayer plus tard.");
            }
        });
    }
}

