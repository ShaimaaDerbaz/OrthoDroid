package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;
import com.example.shaimaaderbaz.orthoclinic.views.EditItemsView;
import com.example.shaimaaderbaz.orthoclinic.views.EditOperationsView;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class EditItemPresenterImp implements EditItemPresenter ,BaseResponseCall{

    private AddPatientView addPatientView;
    private EditItemsView editItemsView;
    public EditItemPresenterImp(EditItemsView editItemsView)
    {
        this.editItemsView=editItemsView;
    }
    // implement from Presenter
    @Override
    public void UploadVediosToServer(int patient_id, OperationsItem operationsItem)
    {
        DataCalls dataCalls =new DataCalls();
//        dataCalls.addpatient(patientItem);
    }

    @Override
    public void EditItemRadiationToServer(int rad_id, RadiationItem radiationItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.updateRadiation(rad_id,new RetrofitModels.Radiation(radiationItem.getInfo()),this);
    }
    @Override
    public void DeleteItemFromServer(PatientItem patientItem)
    {
        DataCalls dataCalls =new DataCalls();
//        dataCalls.addpatient(patientItem);
    }
    @Override
    public void success() {
        editItemsView.setItemsUpdateSucessfull();

    }

    @Override
    public void error(String message) {
        editItemsView.setItemsUpdateFailure();
    }
}
