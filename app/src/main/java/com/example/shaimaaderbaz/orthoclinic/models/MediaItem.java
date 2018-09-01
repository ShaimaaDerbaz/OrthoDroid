package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.SerializedName;

public class MediaItem {
    @SerializedName("id")
    private int id;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    @SerializedName("taken_on")
    private String takenOn;

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getTakenOn() {
        return takenOn;
    }
}
