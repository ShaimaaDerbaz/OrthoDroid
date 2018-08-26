package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.network.AllPatientsCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;
import com.example.shaimaaderbaz.orthoclinic.views.PatientListView;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class PatientListPresenterImp implements PatientListPresenter ,PatientListInteractor.OnRetreivePatientsFinishedListener {

    private PatientListView patientListView;
    public PatientListPresenterImp(PatientListView patientListView)
    {
        this.patientListView=patientListView;
    }
     AllPatientsCall presenterCallback =new AllPatientsCall() {
         @Override
         public void success(List<PatientItem> patientItems) {
             patientListView.showPatients(patientItems);
         }

         @Override
         public void error(String error) {

         }
     };
    // implement from AddPatientPresenter
    @Override
    public void retreivePatientsFromServer()
    {
        //DataCalls
        DataCalls dataCalls=new DataCalls();
        dataCalls.getAllpatients(presenterCallback);
    }
    //implement from Interactor
    @Override
    public void onPatientRetreivesSucessfull(Context context ,List<PatientItem> allPatientData)
    {
        patientListView.showPatients(allPatientData);
    }

    @Override
    public void onPatientsRetreiveFailure(Context context ,List<PatientItem> allPatientData)
    {
        patientListView.showPatients(allPatientData);
    }
}