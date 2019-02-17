package com.mlbas.iotinternshipapplication.repository;

import android.arch.lifecycle.LiveData;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mlbas.iotinternshipapplication.api.FetchApi;
import com.mlbas.iotinternshipapplication.interfaces.Callback;
import com.mlbas.iotinternshipapplication.interfaces.OnFinishRequest;
import com.mlbas.iotinternshipapplication.entities.RecyclerListItem;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;



public class ItemRepository {

    LiveData<ArrayList<RecyclerListItem>> itens;

    public void getList(String path, final Callback handler){

        FetchApi api = new FetchApi(new OnFinishRequest() {
            @Override
            public void OnFinishRequest(String data) {
                ArrayList<RecyclerListItem> myList = new ArrayList<>();
                try {
                    Gson g = new Gson();
                    Type collectionType = new TypeToken<Collection<RecyclerListItem>>() {
                    }.getType();
                    Collection<RecyclerListItem> enums = g.fromJson(data, collectionType);
                    for(RecyclerListItem i : enums){
                        myList.add(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.onFinish(myList);
            }

            @Override
            public void OnError(String msg) {

            }
        });
        api.fetchData(path, "GET");
    }
}
