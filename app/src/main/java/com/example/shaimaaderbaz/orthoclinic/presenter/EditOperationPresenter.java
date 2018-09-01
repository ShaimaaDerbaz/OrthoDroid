package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditOperationPresenter {

    void UploadVediosToServer(int patient_id, OperationsItem operationsItem);
    void UploadImagesToServer(int patient_id, OperationsItem operationsItem);
    void EditItemToServer(int patient_id,int op_id, OperationsItem operationsItem);
    void DeleteItemFromServer(PatientItem patientItem);
}


