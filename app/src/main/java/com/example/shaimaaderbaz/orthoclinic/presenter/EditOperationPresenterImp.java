package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;
import com.example.shaimaaderbaz.orthoclinic.views.EditOperationsView;

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
    public void UploadVediosToServer(int patient_id, OperationsItem operationsItem)
    {
        DataCalls dataCalls =new DataCalls();
       // dataCalls.addpatient(patientItem);
    }

    @Override
    public void UploadImagesToServer(int patient_id, OperationsItem operationsItem)
    {
        DataCalls dataCalls =new DataCalls();
        // dataCalls.addpatient(patientItem);
    }

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
    public void DeleteItemFromServer(PatientItem patientItem)
    {
        DataCalls dataCalls =new DataCalls();
//        dataCalls.addpatient(patientItem);
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
