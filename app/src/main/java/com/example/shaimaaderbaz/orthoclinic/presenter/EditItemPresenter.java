package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.ComplainItem;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;
import com.example.shaimaaderbaz.orthoclinic.models.MediaItem;
import com.example.shaimaaderbaz.orthoclinic.models.MedicalHistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditItemPresenter {

    void EditItemRadiationToServer(int rad_id, RadiationItem radiationItem);
    void EditItemLabToServer(int lab_id, LabItem labItem);
    void EditItemComplainToServer(int comp_id, ComplainItem complain );
    void EditItemMedicalHistoryToServer(int hist_id, MedicalHistoryItem medicalHistoryItem );

    void deleteItemRadiation(int mRadiationtId);

    void deleteItemLab(int mLabId);

    void deleteItemComplain(int mCompId);

    void deleteItemHistory(int mHistoryId);

    void uploadMediaToServer(int objectId, List<String> filePaths,int owner);

    void retreiveItemImages(List<MediaItem> mediaItems);



}


