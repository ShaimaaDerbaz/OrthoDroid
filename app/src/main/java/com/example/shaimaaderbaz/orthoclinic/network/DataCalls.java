package com.example.shaimaaderbaz.orthoclinic.network;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.PersonalItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public class DataCalls {
    private OrthoAPI orthoAPI;

    public DataCalls() {
        orthoAPI = Utils.getOrthoAPI();
    }

    public void getAllpatients(final AllPatientsCall presenterCallback) {

        Call<AllPatientData> call = orthoAPI.getAllPatients();

        call.enqueue(new Callback<AllPatientData>() {
            @Override
            public void onResponse(Call<AllPatientData> call, Response<AllPatientData> response) {
                List<PatientItem> allPatientData = response.body().getPatients();
                presenterCallback.success(allPatientData);

            }

            @Override
            public void onFailure(Call<AllPatientData> call, Throwable t) {

            }
        });
    }

    public void addpatient( final PatientItem patientItem) {

        Call<PatientItem> call = orthoAPI.savePatient(patientItem);

        call.enqueue(new Callback<PatientItem>() {
            @Override
            public void onResponse(Call<PatientItem> call, Response<PatientItem> response) {
                if (response.isSuccessful()) {

                }

            }

            @Override
            public void onFailure(Call<PatientItem> call, Throwable t) {

            }
        });
    }
    public void getAllData(final AllDataCall presenterCallback) {
        orthoAPI.getAllData().enqueue(new Callback<RetrofitModels.AllDataResponse>() {
            @Override
            public void onResponse(Call<RetrofitModels.AllDataResponse> call, Response<RetrofitModels.AllDataResponse> response) {
                presenterCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<RetrofitModels.AllDataResponse> call, Throwable t) {
                presenterCallback.error(t.getMessage());
            }
        });
    }

    public void addMedicalHistory(List<RetrofitModels.MedicalHistory> history,
                                  int patientId,
                                  final BaseResponseCall baseResponseCall) {
        orthoAPI.addMedicalHistory(new RetrofitModels.AddMedicalHistoryRequest(
                history,patientId
        )).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                baseResponseCall.success();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                baseResponseCall.error(t.getMessage());
            }
        });
    }

}
