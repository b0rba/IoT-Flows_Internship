package com.mlbas.iotinternshipapplication.vModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.mlbas.iotinternshipapplication.interfaces.Callback;
import com.mlbas.iotinternshipapplication.entities.RecyclerListItem;
import com.mlbas.iotinternshipapplication.repository.ItemRepository;

import java.util.ArrayList;


public class MyViewModel extends ViewModel {

    private MutableLiveData<ArrayList<RecyclerListItem>> itens = new MutableLiveData<>();
    private ItemRepository repo;

    public MyViewModel(){
        repo = new ItemRepository();
    }

    public LiveData<ArrayList<RecyclerListItem>> getItens(){
        return itens;
    }

    public void LoadItens(){
        String path = "https://jsonplaceholder.typicode.com/todos/";

        repo.getList(path, new Callback(){

            @Override
            public void onFinish(Object data) {
                itens.postValue((ArrayList<RecyclerListItem>) data);
            }
        });
    }

    public LiveData<ArrayList<RecyclerListItem>> getSelected(){
        return this.itens;
    }
}
