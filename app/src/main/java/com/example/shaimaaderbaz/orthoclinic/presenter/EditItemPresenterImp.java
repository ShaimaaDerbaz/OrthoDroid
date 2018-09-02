package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.ComplainItem;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;
import com.example.shaimaaderbaz.orthoclinic.models.MedicalHistoryItem;
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
    public void EditItemRadiationToServer(int rad_id, RadiationItem radiationItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.updateRadiation(rad_id,new RetrofitModels.Radiation(radiationItem.getInfo()),this);
    }
    @Override
    public void EditItemLabToServer(int lab_id, LabItem labItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.updateLab(lab_id,new RetrofitModels.Lab(labItem.getInfo()),this);
    }
    @Override
    public void EditItemComplainToServer(int comp_id,ComplainItem complain)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.updateComplain(comp_id,new RetrofitModels.Complain(complain.getInfo()),this);
    }
    @Override
    public void EditItemMedicalHistoryToServer(int hist_id, MedicalHistoryItem medicalHistoryItem )
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.updateMedicalHistory(hist_id,new RetrofitModels.MedicalHistory(medicalHistoryItem.getInfo()),this);
    }

    @Override
    public void deleteItemRadiation(int mRadiationtId) {
        DataCalls dataCalls = new DataCalls();
        dataCalls.deleteRadiation(mRadiationtId, new BaseResponseCall() {
            @Override
            public void success() {
                editItemsView.setItemDeleteSuccessful();
            }

            @Override
            public void error(String message) {
                editItemsView.setItemDeleteFailure();
            }
        });
    }

    @Override
    public void deleteItemLab(int mLabId) {
        DataCalls dataCalls = new DataCalls();
        dataCalls.deleteLab(mLabId, new BaseResponseCall() {
            @Override
            public void success() {
                editItemsView.setItemDeleteSuccessful();
            }

            @Override
            public void error(String message) {
                editItemsView.setItemDeleteFailure();
            }
        });
    }

    @Override
    public void deleteItemComplain(int mCompId) {
        DataCalls dataCalls = new DataCalls();
        dataCalls.deleteComplain(mCompId, new BaseResponseCall() {
            @Override
            public void success() {
                editItemsView.setItemDeleteSuccessful();
            }

            @Override
            public void error(String message) {
                editItemsView.setItemDeleteFailure();
            }
        });
    }
    @Override
    public void deleteItemHistory(int mHistoryId)
    {
        DataCalls dataCalls = new DataCalls();
        dataCalls.deleteComplain(mHistoryId,this);
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
