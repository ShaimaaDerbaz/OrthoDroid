package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class AddPatientPresenterImp implements AddPatientPresenter ,AddPatientInteractor.OnAddPatientFinishedListener {

    private AddPatientView addPatientView;
    public AddPatientPresenterImp(AddPatientView addPatientView)
    {
        this.addPatientView=addPatientView;
    }
    // implement from AddPatientPresenter
    @Override
    public void addPatientToServer(PatientItem patientItem)
    {
        String patientId;String patientName;String patientAge;String occupation;String patientWeight;String patientInfo;
        //Save user to database on Server

    }
    //implement from AddPatientInteractor
    @Override
    public void onPatientCreateSucessfull(Context context)
    {
        addPatientView.setPatientCreateSucessfull(context);
    }

    @Override
    public void onPatientCreateFailure(Context context)
    {
        addPatientView.setPatientCreateFailure(context);
    }
}
