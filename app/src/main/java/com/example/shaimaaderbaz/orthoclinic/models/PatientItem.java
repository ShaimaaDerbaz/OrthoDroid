package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shaimaa Derbaz on 8/6/2018.
 */

public class PatientItem {
    @SerializedName("id")
    @Expose
    String id ;
    @SerializedName("p_id")
    @Expose
    String p_id ;
    @SerializedName("name")
    @Expose
    String patientName ;
    @SerializedName("occupation")
    @Expose
    String occup ;
    @SerializedName("additional_info")
    @Expose
    String info;
    @SerializedName("created_at")
    @Expose
    String created_date;
    @SerializedName("updated_at")
    @Expose
    String updated_date;
    @SerializedName("age")
    @Expose
    Integer age ;
    @SerializedName("weight")
    @Expose
    Integer weight;

    String local_id;
    Integer flag;


    public PatientItem() {

    }

    public PatientItem(String patientName, String id, String occup, String info, Integer age, Integer weight,String created_date) {
        this.patientName = patientName;
        this.id = id;
        this.occup = occup;
        this.info = info;
        this.age = age;
        this.weight = weight;
        this.created_date =created_date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOccup() {
        return occup;
    }

    public void setOccup(String occup) {
        this.occup = occup;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(String created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
