package com.itumaster.madaventure.service;

import com.google.gson.reflect.TypeToken;
import com.itumaster.madaventure.model.ApiResponse;
import com.itumaster.madaventure.model.Province;
import com.itumaster.madaventure.model.Utilisateur;
import com.itumaster.madaventure.model.minterface.ApiResponseListener;
import com.itumaster.madaventure.util.NetworkUtils;

import java.lang.reflect.Type;
import java.util.List;

public class ProvinceService {

    private static final String BASE_URL = "https://backend-madaventure-production.up.railway.app/api/v1/province/";
    private static final String TAG = "Province Service";

    public static void getListProvince(final ApiResponseListener<List<Province>> listener) {
        String url = "";
        NetworkUtils.performGetRequestAsync(BASE_URL + url, new NetworkUtils.NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Type provinceListType = new TypeToken<List<Province>>() {}.getType();
                ApiResponse<List<Province>> apiResponse = ApiResponse.fromJson(response, provinceListType);
                if (apiResponse.isSuccess()) {
                    List<Province> provinces = apiResponse.getData();
                    listener.onSuccess(provinces);
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

    public static void getDetails(String provinceId, final ApiResponseListener<Province> listener) {
        String url = "" + provinceId;
        NetworkUtils.performGetRequestAsync(BASE_URL + url, new NetworkUtils.NetworkCallback() {
            @Override
            public void onSuccess(String response) {
                Type userType = new TypeToken<Province>() {}.getType();
                ApiResponse<Province> apiResponse = ApiResponse.fromJson(response, userType);
                if (apiResponse.isSuccess()) {
                    Province province = apiResponse.getData();
                    listener.onSuccess(province);
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
