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
    /*@SerializedName("info")
    @Expose
    private String info;*/

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
}
