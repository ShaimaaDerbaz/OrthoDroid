package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.ComplainItem;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditItemPresenter {

    void UploadVediosToServer(int patient_id, OperationsItem operationsItem);
    void EditItemRadiationToServer(int rad_id, RadiationItem radiationItem);
    void EditItemLabToServer(int lab_id, LabItem labItem);
    void EditItemComplainToServer(int comp_id, ComplainItem complain );
    void DeleteItemFromServer(PatientItem patientItem);
}


