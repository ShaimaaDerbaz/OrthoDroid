package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;
import com.example.shaimaaderbaz.orthoclinic.views.EditOperationsView;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class EditItemPresenterImp implements EditItemPresenter ,BaseResponseCall{

    private AddPatientView addPatientView;
    private EditOperationsView editOperationsView;
    public EditItemPresenterImp(AddPatientView addPatientView)
    {
        this.addPatientView=addPatientView;
    }
    // implement from Presenter
    @Override
    public void UploadVediosToServer(int patient_id, OperationsItem operationsItem)
    {
        DataCalls dataCalls =new DataCalls();
//        dataCalls.addpatient(patientItem);
    }

    @Override
    public void EditItemRadiationToServer(int patient_id, RadiationItem radiationItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.updateRadiation(new RetrofitModels.Radiation(radiationItem.getInfo()),patient_id,this);
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
