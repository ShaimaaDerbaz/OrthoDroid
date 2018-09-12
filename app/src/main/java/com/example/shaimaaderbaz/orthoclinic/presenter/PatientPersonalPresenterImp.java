package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientInfoData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.network.AllPatientsCall;
import com.example.shaimaaderbaz.orthoclinic.network.AllPatientsInfoCall;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.PatientListView;
import com.example.shaimaaderbaz.orthoclinic.views.PatientPersonalView;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class PatientPersonalPresenterImp implements PatientPersonalPresenter  {

    private PatientPersonalView patientPersonalView;
    public PatientPersonalPresenterImp(PatientPersonalView patientPersonalView)
    {
        this.patientPersonalView=patientPersonalView;
    }
     AllPatientsInfoCall presenterCallback =new AllPatientsInfoCall() {
         @Override
         public void success(AllPatientInfoData allPatientInfoData ,int patient_id) {
             patientPersonalView.showPatientInfo(allPatientInfoData,patient_id);
         }

         @Override
         public void error(String error) {

         }
     };
    // implement from Presenter
    @Override
    public void retreivePatientInfoFromServer(int patient_id)
    {
        //DataCalls
        DataCalls dataCalls=new DataCalls();
        dataCalls.getAllpatientInfo(presenterCallback,patient_id);
    }

    @Override
    public void deleteItemPatient(int patientId) {
        DataCalls dataCalls = new DataCalls();
        dataCalls.deletePatient(patientId, new BaseResponseCall() {
            @Override
            public void success() {
                patientPersonalView.setItemDeleteSuccessful();
            }

            @Override
            public void error(String message) {
                patientPersonalView.setItemDeleteFailure();
            }
        });
    }

}
