package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.app.Activity;

import com.example.shaimaaderbaz.orthoclinic.activities.AddPatientActivity;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface AddPatientPresenter {

    void addPatientToServer(PatientItem patientItem);
}


