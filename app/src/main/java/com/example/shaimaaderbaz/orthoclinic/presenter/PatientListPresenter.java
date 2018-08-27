package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface PatientListPresenter {

    void retreivePatientsFromServer();
    void filterPatientsResult(String text,List<PatientItem> dataSet);
}


