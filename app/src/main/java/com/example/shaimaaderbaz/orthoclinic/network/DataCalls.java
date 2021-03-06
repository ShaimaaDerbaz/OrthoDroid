package com.example.shaimaaderbaz.orthoclinic.network;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.AllPatientInfoData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.PersonalItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public class DataCalls {
    private OrthoAPI orthoAPI;
    List<PatientItem> allPatients;

    public DataCalls() {
        orthoAPI = Utils.getOrthoAPI();
    }

   /* public void getAllpatients(final AllPatientsCall presenterCallback)
    {

        Call<AllPatientData> call = orthoAPI.getAllPatients();
        call.enqueue(new Callback<AllPatientData>() {
            @Override
            public void onResponse(Call<AllPatientData> call, Response<AllPatientData> response) {
                if (response.body() != null) {
                    List<PatientItem> allPatientData = response.body().getPatients();
                    presenterCallback.success(allPatientData);

                } else
                    presenterCallback.error("Unknown Error");

            }

            @Override
            public void onFailure(Call<AllPatientData> call, Throwable t) {
                presenterCallback.error(t.getMessage());
            }
        });
    }*/

    public List<PatientItem> getAllpatients(final AllPatientsCall presenterCallback) {

        Call<AllPatientData> call = orthoAPI.getAllPatients();

        call.enqueue(new Callback<AllPatientData>() {
            @Override
            public void onResponse(Call<AllPatientData> call, Response<AllPatientData> response) {
                if (response.body() != null) {
                    List<PatientItem> allPatientData = response.body().getPatients();
                    presenterCallback.success(allPatientData);
                    allPatients=allPatientData;

                } else
                    presenterCallback.error("Unknown Error");

            }

            @Override
            public void onFailure(Call<AllPatientData> call, Throwable t) {
                presenterCallback.error(t.getMessage());
            }
        });
        return allPatients;
    }

    public void addpatient(final PatientItem patientItem, final BaseResponseCall presenterCall) {

        Call<ResponseBody> call = orthoAPI.savePatient(patientItem);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    presenterCall.success();
                } else
                    presenterCall.error("Unkown Error");

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                presenterCall.error(t.getMessage());
            }
        });
    }

    public void deletePatient(int patientId, final BaseResponseCall baseResponseCall) {
        orthoAPI.deletePatient(patientId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                    baseResponseCall.success();
                else
                    baseResponseCall.error("Unkown Error");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                baseResponseCall.error(t.getMessage());
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


    public void getAllpatientInfo(final AllPatientsInfoCall presenterCallback, final int patient_id) {

        Call<AllPatientInfoData> call = orthoAPI.getAllPatientInfo(patient_id);

        call.enqueue(new Callback<AllPatientInfoData>() {
            @Override
            public void onResponse(Call<AllPatientInfoData> call, Response<AllPatientInfoData> response) {
                AllPatientInfoData allPatientInfoData = response.body();
                presenterCallback.success(allPatientInfoData, patient_id);

            }

            @Override
            public void onFailure(Call<AllPatientInfoData> call, Throwable t) {
                presenterCallback.error(t.getMessage());


            }
        });

    }

    public void addMedicalHistory(List<RetrofitModels.MedicalHistory> history, int patientId, final BaseResponseCall baseResponseCall) {
        orthoAPI.addMedicalHistory(new RetrofitModels.AddMedicalHistoryRequest(history, patientId)).enqueue(new Callback<ResponseBody>() {
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

    public void updateMedicalHistory(int hist_id,RetrofitModels.MedicalHistory medicalHistory, final BaseResponseCall baseResponseCall) {
        long history_id = hist_id;
        orthoAPI.updateMedicalHistory(history_id,medicalHistory).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void addComplain(List<RetrofitModels.Complain> complains, int patientId, final BaseResponseCall baseResponseCall) {
        orthoAPI.addComplain(new RetrofitModels.AddComplainRequest(complains, patientId)).enqueue(new Callback<ResponseBody>() {
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

    public void updateComplain(int comp_id,RetrofitModels.Complain complain, final BaseResponseCall baseResponseCall) {
        orthoAPI.updateComplain((long) comp_id,complain).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void deleteComplain(int complainId, final BaseResponseCall baseResponseCall) {
        orthoAPI.deleteComplain(complainId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                    baseResponseCall.success();
                else
                    baseResponseCall.error("Unkown Error");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                baseResponseCall.error(t.getMessage());
            }
        });
    }

    public void addOperation(RetrofitModels.Operation operation,
                             int patientId,
                             final BaseResponseCall baseResponseCall) {
        ArrayList<RetrofitModels.Operation> operations = new ArrayList<>();
        operations.add(operation);
        orthoAPI.addOperation(new RetrofitModels.AddOperationRequest(operations, patientId)).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void updateOperation(RetrofitModels.Operation operation, int patientId,int operation_id, final BaseResponseCall baseResponseCall) {
        //ArrayList<RetrofitModels.Operation> operations = new ArrayList<>();
        //operations.add(operation);
        RetrofitModels.Operation finalOperation=new RetrofitModels.Operation(operation.getName(),operation.getSteps(),operation.getDate(),operation.getPersons(),operation.getFollowUp());
        orthoAPI.updateOperation(operation_id,finalOperation).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void deleteOperation(int operationId, final BaseResponseCall baseResponseCall){
        orthoAPI.deleteOperation(operationId).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void addLab(List<RetrofitModels.Lab> labs, int patientId, final BaseResponseCall baseResponseCall) {
        orthoAPI.addLab(new RetrofitModels.AddLabRequest(labs, patientId)).enqueue(new Callback<ResponseBody>() {
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

    public void updateLab(int lab_id,RetrofitModels.Lab lab, final BaseResponseCall baseResponseCall) {
        long laboratory_id = lab_id;
        orthoAPI.updateLab(laboratory_id,lab).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void deleteLab(int labId, final BaseResponseCall baseResponseCall) {
        orthoAPI.deleteLab(labId).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void addRadiation(List<RetrofitModels.Radiation> radiations, int patientId, final BaseResponseCall baseResponseCall) {
        orthoAPI.addRadiation(new RetrofitModels.AddRadiationRequest(radiations, patientId)).enqueue(new Callback<ResponseBody>() {
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

    public void updateRadiation(int rad_id,RetrofitModels.Radiation radiation, final BaseResponseCall baseResponseCall) {
        long radiationId_id = rad_id;
        orthoAPI.updateRadiation(radiationId_id,radiation).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void deleteRadiation(int radiationId, final BaseResponseCall baseResponseCall){
        orthoAPI.deleteRadiation(radiationId).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }

    public void deleteMedicalHistory(int historyId, final BaseResponseCall baseResponseCall) {
        orthoAPI.deleteMedicalHistory(historyId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                    baseResponseCall.success();
                else
                    baseResponseCall.error("Unkown Error");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                baseResponseCall.error(t.getMessage());
            }
        });
    }

    public void uploadMedia(List<String> paths, int ownerId, int objectId,
                            final BaseResponseCall baseResponseCall) {
        ArrayList<MultipartBody.Part> media = new ArrayList<>();
        for (int i=0; i<paths.size(); i++) {
            File file = new File(paths.get(i));
            RequestBody requestFile = RequestBody.create(MediaType.parse(
                    "multipart/form-data"
            ), file);
            media.add(MultipartBody.Part.createFormData("media["+String.valueOf(i)+"]",file.getName(),requestFile));
        }

        orthoAPI.uploadMedia(objectId,ownerId,media).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                    baseResponseCall.success();
                else
                    baseResponseCall.error("UnkwonError");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                baseResponseCall.error(t.getMessage());
            }
        });
    }

    public void deleteMedia(int mediaId, final BaseResponseCall baseResponseCall) {
        orthoAPI.deleteMedia(mediaId).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            baseResponseCall.success();
                        } else
                            baseResponseCall.error("Unkown Error");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        baseResponseCall.error(t.getMessage());
                    }
                }
        );
    }
}
