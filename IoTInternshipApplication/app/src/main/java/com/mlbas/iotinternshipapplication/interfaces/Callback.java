package com.mlbas.iotinternshipapplication.interfaces;

// will pass back the data
public interface Callback<T> {
    void onFinish(T data);
}
