package com.mlbas.iotinternshipapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mlbas.iotinternshipapplication.R;
import com.mlbas.iotinternshipapplication.entities.RecyclerListItem;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<RecyclerListItem> arrayList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<RecyclerListItem> al){
        this.arrayList = al;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.recycle_list, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(String.valueOf(arrayList.get(i).getTitle()));
        myViewHolder.id.setText(String.valueOf(arrayList.get(i).getId()));
        myViewHolder.assistido.setText(String.valueOf(arrayList.get(i).isCompleted()));
        myViewHolder.userId.setText(String.valueOf(arrayList.get(i).getUserId()));
    }

    public void setList(ArrayList<RecyclerListItem> r){
        this.arrayList = r;
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView title;
        TextView assistido;
        TextView userId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.id = itemView.findViewById(R.id.filme_id);
            this.title = itemView.findViewById(R.id.title);
            this.assistido = itemView.findViewById(R.id.assistido);
            this.userId = itemView.findViewById(R.id.usuario_id);
        }
    }
}
