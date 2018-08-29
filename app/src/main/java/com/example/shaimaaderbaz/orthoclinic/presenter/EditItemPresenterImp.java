package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class EditItemPresenterImp implements EditItemPresenter ,EditItemInteractor.OnEditItemFinishedListener {

    private AddPatientView addPatientView;
    public EditItemPresenterImp(AddPatientView addPatientView)
    {
        this.addPatientView=addPatientView;
    }
    // implement from Presenter
    @Override
    public void UploadMediaToServer(PatientItem patientItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.addpatient(patientItem);
    }

    @Override
    public void EditItemToServer(PatientItem patientItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.addpatient(patientItem);
    }
    @Override
    public void DeleteItemFromServer(PatientItem patientItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.addpatient(patientItem);
    }
    //implement from AddPatientInteractor

    @Override
    public void onEditItemSucessfull(Context context)
    {
        addPatientView.setPatientCreateSucessfull();
    }

    @Override
    public void onEditItemFailure(Context context)
    {
        addPatientView.setPatientCreateFailure();
    }
    @Override
    public void onUploudItemMediaSucessfull(Context context)
    {

    }
    @Override
    public void onUploudItemMediaFailure(Context context)
    {

    }
    @Override
    public void onDeleteItemSucessfull(Context context)
    {

    }
    @Override
    public void onDeleteItemFailure(Context context)
    {

    }
}
