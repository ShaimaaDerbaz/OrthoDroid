package com.example.shaimaaderbaz.orthoclinic.network;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.AllPatientInfoData;
import com.example.shaimaaderbaz.orthoclinic.models.ComplainItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;

import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;

import java.util.List;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Shaimaa Derbaz on 8/24/2018.
 */

public interface OrthoAPI {

    @POST("/api/patients")
    Call<ResponseBody> savePatient(@Body PatientItem patientItem);

    @GET("/api/patients")
    Call<AllPatientData> getAllPatients();

    @GET("/api/data")
    Call<RetrofitModels.AllDataResponse> getAllData();


    @GET("/api/patients/{patient_id}")
    Call<AllPatientInfoData> getAllPatientInfo(@Path("patient_id") long patient_id);

    @DELETE("/api/patients/{patient_id}")
    Call<ResponseBody> deletePatient(@Path("patient_id") long patient_id);

    @POST("/api/medical-history")
    Call<ResponseBody> addMedicalHistory(@Body RetrofitModels.AddMedicalHistoryRequest medicalHistoryRequest);

    @PATCH("/api/medical-history/{history_id}")
    Call<ResponseBody> updateMedicalHistory(@Path("history_id") long history_id,@Body RetrofitModels.MedicalHistory medicalRequest);

    @DELETE("/api/medical-history/{history_id}")
    Call<ResponseBody> deleteMedicalHistory(@Path("history_id") long history_id);

    @POST("/api/complains")
    Call<ResponseBody> addComplain(@Body RetrofitModels.AddComplainRequest complainRequest);


    @POST("/api/labs")
    Call<ResponseBody> addLab(@Body RetrofitModels.AddLabRequest labRequest);

    @POST("/api/radiations")
    Call<ResponseBody> addRadiation(@Body RetrofitModels.AddRadiationRequest radiationRequest);


    @POST("/api/operations")
    Call<ResponseBody> addOperation(@Body RetrofitModels.AddOperationRequest operationRequest);

    @PATCH("api/operations/{operation_id}")
    Call<ResponseBody> updateOperation(@Path("operation_id") long operation_id,
                                       @Body RetrofitModels.Operation operationRequest);

    @DELETE("api/operations/{operation_id}")
    Call<ResponseBody> deleteOperation(@Path("operation_id") long operation_id);

    @PATCH("api/radiations/{radiation_id}")
    Call<ResponseBody> updateRadiation(@Path("radiation_id") long radiation_id,@Body RetrofitModels.Radiation radiationRequest);

    @DELETE("api/radiations/{radiation_id}")
    Call<ResponseBody> deleteRadiation(@Path("radiation_id") long radiationId);

    @PATCH("/api/labs/{lab_id}")
    Call<ResponseBody> updateLab(@Path("lab_id") long lab_id,@Body RetrofitModels.Lab labRequest);

    @DELETE("/api/labs/{lab_id}")
    Call<ResponseBody> deleteLab(@Path("lab_id") long lab_id);

    @PATCH("/api/complains/{complain_id}")
    Call<ResponseBody> updateComplain(@Path("complain_id") long complain_id,@Body RetrofitModels.Complain complainbRequest);

    @DELETE("/api/complains/{complain_id}")
    Call<ResponseBody> deleteComplain(@Path("complain_id") long complain_id);

    @Multipart
    @POST("api/media")
    Call<ResponseBody> uploadMedia(@Part("id") int id,
                                   @Part("owner") int ownerId,
                                   @Part() List<MultipartBody.Part> media);

    @DELETE("/api/media/{media_id}")
    Call<ResponseBody> deleteMedia(@Path("media_id") long media_id);

}
