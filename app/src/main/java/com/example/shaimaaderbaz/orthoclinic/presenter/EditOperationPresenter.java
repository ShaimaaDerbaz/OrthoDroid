package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.MediaItem;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditOperationPresenter {


    void EditItemToServer(int patient_id,int op_id, OperationsItem operationsItem);
    void deleteItemOperation(int mOperationId);
    void uploadMediaToServer(int objectId, List<String> filePaths);
    void deleteMediaItem(int mediaId);

}


