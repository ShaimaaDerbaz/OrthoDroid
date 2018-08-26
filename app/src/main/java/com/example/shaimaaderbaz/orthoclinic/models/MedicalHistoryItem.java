package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shaimaa Derbaz on 8/26/2018.
 */

public class MedicalHistoryItem {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("state_name")
    @Expose
    private String state_name;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("patient_id")
    @Expose
    private Integer patient_id;
    @SerializedName("history_id")
    @Expose
    private Integer history_id;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;

    public MedicalHistoryItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
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

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getHistory_id() {
        return history_id;
    }

    public void setHistory_id(Integer history_id) {
        this.history_id = history_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
