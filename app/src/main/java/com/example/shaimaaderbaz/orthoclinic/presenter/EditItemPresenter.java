package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditItemPresenter {

    void UploadMediaToServer(PatientItem patientItem);
    void EditItemToServer(PatientItem patientItem);
    void DeleteItemFromServer(PatientItem patientItem);
}


