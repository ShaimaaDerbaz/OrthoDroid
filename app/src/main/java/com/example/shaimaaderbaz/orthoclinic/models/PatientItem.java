package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/6/2018.
 */

public class PatientItem {
    String patientName ,id,occup,info,lastdate;
    Integer age ,weight;


    public PatientItem() {

    }

    public PatientItem(String patientName, String id, String occup, String info, Integer age, Integer weight,String lastdate) {
        this.patientName = patientName;
        this.id = id;
        this.occup = occup;
        this.info = info;
        this.age = age;
        this.weight = weight;
        this.lastdate=lastdate;
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

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }
}
