package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;
import android.content.pm.LauncherApps;

import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
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
        DataCalls dataCalls =new DataCalls();
        dataCalls.addpatient(patientItem);
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
