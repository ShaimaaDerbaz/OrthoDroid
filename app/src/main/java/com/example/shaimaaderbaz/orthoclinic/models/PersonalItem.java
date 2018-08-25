package com.example.shaimaaderbaz.orthoclinic.models;

import java.util.ArrayList;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public class PersonalItem {
    String statusName ,info;
    ArrayList <String> images,videos;

    public PersonalItem() {
    }

    public PersonalItem(String statusName, String info, ArrayList<String> images, ArrayList<String> videos) {
        this.statusName = statusName;
        this.info = info;
        this.images = images;
        this.videos = videos;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<String> videos) {
        this.videos = videos;
    }
}
