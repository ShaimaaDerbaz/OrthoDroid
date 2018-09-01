package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/26/2018.
 */

public class ComplainItem {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("patient_id")
    @Expose
    private Integer patient_id;
    @SerializedName("complain_id")
    @Expose
    private Integer complain_id;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("examination_date")
    @Expose
    private String examination_date;

    @SerializedName("media")
    private List<MediaItem> mediaItems;

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public ComplainItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getComplain_id() {
        return complain_id;
    }

    public void setComplain_id(Integer complain_id) {
        this.complain_id = complain_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getExamination_date() {
        return examination_date;
    }

    public void setExamination_date(String examination_date) {
        this.examination_date = examination_date;
    }
}
