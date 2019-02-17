package com.mlbas.iotinternshipapplication;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;


import com.mlbas.iotinternshipapplication.adapters.MyAdapter;
import com.mlbas.iotinternshipapplication.entities.RecyclerListItem;
import com.mlbas.iotinternshipapplication.fragments.NoMatchDialog;
import com.mlbas.iotinternshipapplication.interfaces.DialogListener;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity  implements DialogListener {


    MyAdapter myAdapter;
    ArrayList<RecyclerListItem> listItemArrayList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listItemArrayList = getIntent().getParcelableArrayListExtra("EXTRA_SEARCH_RESULT");
        myAdapter = new MyAdapter(this, listItemArrayList);
        layoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.id_Recycle_Second_List);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        if (listItemArrayList.size() == 0){
            DialogFragment dialogFragment = new NoMatchDialog();
            dialogFragment.show(getSupportFragmentManager(), "DialogNoMatch");
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }
}
