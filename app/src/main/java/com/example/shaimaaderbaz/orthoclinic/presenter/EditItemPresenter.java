package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditItemPresenter {

    void UploadVediosToServer(int patient_id, OperationsItem operationsItem);
    void EditItemRadiationToServer(int rad_id, RadiationItem radiationItem);
    void DeleteItemFromServer(PatientItem patientItem);
}


