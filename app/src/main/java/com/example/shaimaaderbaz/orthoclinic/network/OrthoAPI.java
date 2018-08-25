package com.example.shaimaaderbaz.orthoclinic.network;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import retrofit2.Call;
import retrofit2.http.Body;

import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Shaimaa Derbaz on 8/24/2018.
 */

public interface OrthoAPI {

    @POST("/api/patients")
    Call<PatientItem> savePatient(@Body PatientItem patientItem);

    @GET("/api/patients")
    Call<AllPatientData> getAllPatients();

    @GET("/api/data")
    Call<RetrofitModels.AllDataResponse> getAllData();

}
