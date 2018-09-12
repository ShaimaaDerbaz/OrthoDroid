package com.example.shaimaaderbaz.orthoclinic.presenter;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface PatientPersonalPresenter {

    void retreivePatientInfoFromServer(int patient_id);
    void deleteItemPatient(int mOperationId);
}


