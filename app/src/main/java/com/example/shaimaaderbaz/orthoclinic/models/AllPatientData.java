package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public class AllPatientData {

    @SerializedName("data")
    @Expose
    private List<PatientItem> patients;

    public AllPatientData() {
    }

    public AllPatientData(List<PatientItem> patients) {
        this.patients = patients;
    }

    public List<PatientItem> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientItem> patients) {
        this.patients = patients;
    }
}
