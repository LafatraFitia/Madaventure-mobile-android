package com.itumaster.madaventure.model;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasData() {
        return this.data != null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApiResponse{");
        sb.append("success=").append(success);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public static <T> ApiResponse<T> fromJson(String jsonString, Type dataType) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            ApiResponse<T> apiResponse = new ApiResponse<>();
            apiResponse.setSuccess( jsonObject.getBoolean("success"));
            apiResponse.setMessage(jsonObject.getString("message"));
            Log.d("API Response start", "fromJson: "+apiResponse);
            if (jsonObject.has("data")) {
                JSONObject dataJson = jsonObject.getJSONObject("data");

                apiResponse.setData(dataJson == null ? null : new Gson().fromJson(dataJson.toString(), dataType));
            } else {
                apiResponse.setData(null);
            }
            Log.d("API Response end", "fromJson: "+apiResponse);
            return apiResponse;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}

