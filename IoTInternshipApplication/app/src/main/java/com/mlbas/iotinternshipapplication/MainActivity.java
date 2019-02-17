package com.mlbas.iotinternshipapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mlbas.iotinternshipapplication.adapters.MyAdapter;
import com.mlbas.iotinternshipapplication.entities.RecyclerListItem;
import com.mlbas.iotinternshipapplication.vModel.MyViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RecyclerListItem> itemList;
    private MyViewModel model;

    private Button button;
    private EditText editText;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();

        recyclerView = findViewById(R.id.id_Recycle_List);
        myAdapter = new MyAdapter(this, itemList);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

        button = findViewById(R.id.id_Botao);
        button.setOnClickListener(this);
        editText = findViewById(R.id.id_Text);

        model = ViewModelProviders.of(this).get(MyViewModel.class);
        model.getSelected().observe(this, new Observer<ArrayList<RecyclerListItem>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RecyclerListItem> recyclerListItems) {
                itemList = recyclerListItems;
                myAdapter.setList(recyclerListItems);
                myAdapter.notifyDataSetChanged();
            }
        });

        model.LoadItens();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_Botao:
                input = editText.getText().toString();

                Intent intent = new Intent(this, SecondActivity.class);
                intent.putParcelableArrayListExtra("EXTRA_SEARCH_RESULT", searchString(itemList, input));

                startActivity(intent);
                break;
        }
    }

    public ArrayList<RecyclerListItem> searchString(ArrayList<RecyclerListItem> al, String entry){
        ArrayList<RecyclerListItem> aux = new ArrayList<>();
        if (!entry.isEmpty()){
            for (int i = 0; i < al.size(); i++){
                if (al.get(i).getTitle().contains(entry)){
                    aux.add(al.get(i));
                }
            }
        }

        return aux;
    }
}