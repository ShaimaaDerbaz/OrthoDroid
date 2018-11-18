package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;
import android.database.Cursor;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface PatientListPresenter {

    //void retreivePatientsFromServer();
    List<PatientItem> retreivePatientsFromServer();
    void filterPatientsResult(String text,List<PatientItem> dataSet);
    List <PatientItem> retreiveLocalPatientsFromDatabase(Context mContext);
    Cursor retreiveAllPatientsFromDatabase(Context mContext);
    void addPatientsFromLocalToServer(List<PatientItem> dataSet,Context mContext);
    void addPatientsFromServerToLocal(List<PatientItem> dataSet,Context mContext);

}


