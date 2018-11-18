package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import com.example.shaimaaderbaz.orthoclinic.data.PatientContract;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class AddPatientPresenterImp implements AddPatientPresenter , BaseResponseCall{

    private AddPatientView addPatientView;
    public AddPatientPresenterImp(AddPatientView addPatientView)
    {
        this.addPatientView=addPatientView;
    }
    // implement from AddPatientPresenter
    @Override
    public void addPatientToServer(PatientItem patientItem)
    {
        DataCalls dataCalls =new DataCalls();
        dataCalls.addpatient(patientItem,this);
    }
    @Override
    public void addPatientToDatabase(PatientItem patientItem ,Context mContext)
    {
        ContentValues values = new ContentValues();
        values.put(PatientContract.PatientEntry.COLUMN_p_id,patientItem.getP_id());
        values.put(PatientContract.PatientEntry.COLUMN_p_serv_id,patientItem.getId());
        values.put(PatientContract.PatientEntry.COLUMN_patientName,patientItem.getPatientName());
        values.put(PatientContract.PatientEntry.COLUMN_occup,patientItem.getOccup());
        values.put(PatientContract.PatientEntry.COLUMN_info, patientItem.getInfo());
        values.put(PatientContract.PatientEntry.COLUMN_weight,patientItem.getWeight());
        values.put(PatientContract.PatientEntry.COLUMN_age,patientItem.getAge());
        values.put(PatientContract.PatientEntry.COLUMN_flag,patientItem.getFlag());
       // values.put(PatientContract.PatientEntry.COLUMN_IMAGE_UrL,patientItem.getUrlToImage());
        //values.put(PatientContract.PatientEntry.COLUMN_IMAGE_UrL,patientItem.getUrlToImage());

        Uri newUri = mContext.getContentResolver().insert(PatientContract.PatientEntry.CONTENT_URI, values);

    }

    @Override
    public void success() {
        addPatientView.setPatientCreateSucessfull();

    }

    @Override
    public void error(String message) {
        addPatientView.setPatientCreateFailure();
    }
}
