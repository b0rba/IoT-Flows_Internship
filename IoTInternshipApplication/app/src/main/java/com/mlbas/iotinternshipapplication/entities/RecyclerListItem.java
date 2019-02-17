package com.mlbas.iotinternshipapplication.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class RecyclerListItem implements Parcelable {

    private boolean completed;
    private String title;
    private int id;
    private int userId;


    public RecyclerListItem(int userId, int id, String title,boolean completed){
        this.title = title;
        this.id = id;
        this.userId = userId;
        this.completed = completed;
    }

    protected RecyclerListItem(Parcel in) {
        completed = in.readByte() != 0;
        title = in.readString();
        id = in.readInt();
        userId = in.readInt();
    }

    public static final Creator<RecyclerListItem> CREATOR = new Creator<RecyclerListItem>() {
        @Override
        public RecyclerListItem createFromParcel(Parcel in) {
            return new RecyclerListItem(in);
        }

        @Override
        public RecyclerListItem[] newArray(int size) {
            return new RecyclerListItem[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeByte((byte) (this.completed ? 1 : 0));
        dest.writeString(this.title);
        dest.writeInt(this.id);
        dest.writeInt(this.userId);
    }
}
