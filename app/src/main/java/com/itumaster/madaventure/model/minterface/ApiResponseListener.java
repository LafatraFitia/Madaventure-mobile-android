package com.itumaster.madaventure.model.minterface;

public interface ApiResponseListener<T> {
    void onSuccess(T response);
    void onError(String errorMessage);
}
