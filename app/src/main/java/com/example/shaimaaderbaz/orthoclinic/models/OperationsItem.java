package com.example.shaimaaderbaz.orthoclinic.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class OperationsItem implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("patient_id")
    @Expose
    private Integer patient_id;
    @SerializedName("operation_id")
    @Expose
    private Integer operation_id;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("date")
    @Expose
    String date;
    @SerializedName("persons")
    @Expose
    String persons;
    @SerializedName("follow_up")
    @Expose
    String follow_up;
    @SerializedName("steps")
    @Expose
    String steps;
    @SerializedName("info")
    @Expose
    private String info;


    @SerializedName("media")
    private List<MediaItem> mediaItems;

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }


    public static final Creator<OperationsItem> CREATOR = new Creator<OperationsItem>() {
        @Override
        public OperationsItem createFromParcel(Parcel in) {
            return new OperationsItem(in);
        }

        @Override
        public OperationsItem[] newArray(int size) {
            return new OperationsItem[size];
        }
    };
    public OperationsItem() {
    }

    protected OperationsItem(Parcel in) {
        id = in.readInt();
        name = in.readString();
        patient_id = in.readInt();
        operation_id = in.readInt();
        created_at = in.readString();
        date = in.readString();
        persons = in.readString();
        follow_up = in.readString();
        steps = in.readString();
        info = in.readString();

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

    public Integer getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Integer operation_id) {
        this.operation_id = operation_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getFollow_up() {
        return follow_up;
    }

    public void setFollow_up(String follow_up) {
        this.follow_up = follow_up;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}

