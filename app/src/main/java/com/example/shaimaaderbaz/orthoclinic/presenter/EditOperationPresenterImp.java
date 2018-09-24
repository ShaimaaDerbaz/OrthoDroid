package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.MediaItem;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.utils.Utils;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;
import com.example.shaimaaderbaz.orthoclinic.views.EditOperationsView;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class EditOperationPresenterImp implements EditOperationPresenter ,BaseResponseCall{

    private EditOperationsView editOperationsView;
    public EditOperationPresenterImp(EditOperationsView editOperationsView)
    {
        this.editOperationsView=editOperationsView;
    }
    // implement from Presenter

    @Override
    public void EditItemToServer(int patient_id,int op_id, OperationsItem operationsItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.updateOperation(new RetrofitModels.Operation(
                operationsItem.getName(),
                operationsItem.getSteps(),
                operationsItem.getDate(),
                operationsItem.getPersons(),
                operationsItem.getFollow_up()),patient_id,op_id,this);
    }
    @Override
    public void deleteItemOperation(int mOperationId)
    {
        DataCalls dataCalls = new DataCalls();
        dataCalls.deleteOperation(mOperationId,new BaseResponseCall() {
            @Override
            public void success() {
                editOperationsView.setItemDeleteSuccessful();
            }

            @Override
            public void error(String message) {
                editOperationsView.setItemDeleteFailure();
            }
        });
    }

    @Override
    public void uploadMediaToServer(int objectId, List<String> filePaths) {
        DataCalls dataCalls = new DataCalls();
        dataCalls.uploadMedia(filePaths, Utils.MediaConstants.OPERATION_MEDIA, objectId,
                new BaseResponseCall() {
            @Override
            public void success() {
                editOperationsView.setOperationMediaSuccess();
            }

            @Override
            public void error(String message) {
                editOperationsView.setOperationMediaFailure();
            }
        });
    }

    @Override
    public void deleteMediaItem(int mediaId) {
        DataCalls dataCalls = new DataCalls();
        dataCalls.deleteMedia(mediaId, new BaseResponseCall() {
            @Override
            public void success() {
                editOperationsView.setItemDeleteSuccessful();
            }

            @Override
            public void error(String message) {
                editOperationsView.setItemDeleteFailure();
            }
        });
    }



    @Override
    public void success() {
        editOperationsView.setOperationsUpdateSucessfull();
    }

    @Override
    public void error(String message) {
        editOperationsView.setOperationsUpdateFailure();
    }
}
