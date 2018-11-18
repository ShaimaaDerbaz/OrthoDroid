package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface AddPatientPresenter {

    void addPatientToServer(PatientItem patientItem);
    void addPatientToDatabase(PatientItem patientItem,Context mContext);
}


