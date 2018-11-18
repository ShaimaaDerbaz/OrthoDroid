package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.shaimaaderbaz.orthoclinic.data.PatientContract;
import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.network.AllPatientsCall;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;
import com.example.shaimaaderbaz.orthoclinic.views.PatientListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/4/2018.
 */

public class PatientListPresenterImp implements PatientListPresenter ,PatientListInteractor.OnRetreivePatientsFinishedListener {

    private PatientListView patientListView;

    public PatientListPresenterImp(PatientListView patientListView) {
        this.patientListView = patientListView;
    }

    AllPatientsCall presenterCallback = new AllPatientsCall() {
        @Override
        public void success(List<PatientItem> patientItems) {
            Collections.reverse(patientItems);
            patientListView.showPatients(patientItems);
        }

        @Override
        public void error(String error) {

        }
    };

    // implement from AddPatientPresenter
    /*@Override
    public  void  retreivePatientsFromServer() {
        //DataCalls
        DataCalls dataCalls = new DataCalls();
        dataCalls.getAllpatients(presenterCallback);
    }*/

    @Override
    public  List<PatientItem>  retreivePatientsFromServer() {
        //DataCalls
        DataCalls dataCalls = new DataCalls();
        List<PatientItem> allPatients=dataCalls.getAllpatients(presenterCallback);
        return allPatients;
    }

    @Override
    public  List <PatientItem> retreiveLocalPatientsFromDatabase(Context mContext)
    {
        String[] projection = new String[]{
                PatientContract.PatientEntry._ID,
                PatientContract.PatientEntry.COLUMN_p_serv_id,
                PatientContract.PatientEntry.COLUMN_p_id,
                PatientContract.PatientEntry.COLUMN_patientName,
                PatientContract.PatientEntry.COLUMN_occup,
                PatientContract.PatientEntry.COLUMN_info,
                PatientContract.PatientEntry.COLUMN_created_date,
                PatientContract.PatientEntry.COLUMN_updated_date,
                PatientContract.PatientEntry.COLUMN_age,
                PatientContract.PatientEntry.COLUMN_weight,
                PatientContract.PatientEntry.COLUMN_flag
        };
        List <PatientItem> patientItems = new ArrayList<>();
        Cursor cursor = mContext.getContentResolver().query(PatientContract.PatientEntry.CONTENT_URI, projection,"flag =?",new String[] {String.valueOf(1)}, null);
        if(cursor.moveToFirst())
        {
            do {
                PatientItem patientItem = new PatientItem();
                patientItem.setLocal_id(cursor.getString(0));
                patientItem.setId(cursor.getString(1));
                patientItem.setP_id(cursor.getString(2));
                patientItem.setPatientName(cursor.getString(3));
                patientItem.setOccup(cursor.getString(4));
                patientItem.setInfo(cursor.getString(5));
                patientItem.setCreatedDate(cursor.getString(6));
                patientItem.setUpdated_date(cursor.getString(7));
                patientItem.setAge(Integer.parseInt(cursor.getString(8)));
                patientItem.setWeight(Integer.parseInt(cursor.getString(9)));
                patientItem.setFlag(Integer.parseInt(cursor.getString(10)));

                // Adding contact to list
                patientItems.add(patientItem);
            }while (cursor.moveToNext());
            patientListView.showPatients(patientItems);
        }
        return patientItems;
    }

    @Override
    public Cursor retreiveAllPatientsFromDatabase(Context mContext) {
        String[] projection = new String[]{
                PatientContract.PatientEntry._ID,
                PatientContract.PatientEntry.COLUMN_p_serv_id,
                PatientContract.PatientEntry.COLUMN_p_id,
                PatientContract.PatientEntry.COLUMN_patientName,
                PatientContract.PatientEntry.COLUMN_occup,
                PatientContract.PatientEntry.COLUMN_info,
                PatientContract.PatientEntry.COLUMN_created_date,
                PatientContract.PatientEntry.COLUMN_updated_date,
                PatientContract.PatientEntry.COLUMN_age,
                PatientContract.PatientEntry.COLUMN_weight,
                PatientContract.PatientEntry.COLUMN_flag
        };
    List <PatientItem> patientItems = new ArrayList<>();
    Cursor cursor = mContext.getContentResolver().query(PatientContract.PatientEntry.CONTENT_URI, projection, null, null, null);
    if(cursor.moveToFirst())
    {
        do {
            PatientItem patientItem = new PatientItem();
            patientItem.setLocal_id(cursor.getString(0));
            patientItem.setId(cursor.getString(1));
            patientItem.setP_id(cursor.getString(2));
            patientItem.setPatientName(cursor.getString(3));
            patientItem.setOccup(cursor.getString(4));
            patientItem.setInfo(cursor.getString(5));
            patientItem.setCreatedDate(cursor.getString(6));
            patientItem.setUpdated_date(cursor.getString(7));
            patientItem.setAge(Integer.parseInt(cursor.getString(8)));
            patientItem.setWeight(Integer.parseInt(cursor.getString(9)));
            patientItem.setFlag(Integer.parseInt(cursor.getString(10)));

            // Adding contact to list
            patientItems.add(patientItem);
        }while (cursor.moveToNext());
        patientListView.showPatients(patientItems);
      }
        return cursor;
    }
    @Override
    public void addPatientsFromLocalToServer(List<PatientItem> dataSet ,Context mContext)
    {
        for (int i=0;i<dataSet.size();i++) {
            PatientItem patientItem=dataSet.get(i);
            ContentValues values = new ContentValues();
            values.put(PatientContract.PatientEntry.COLUMN_p_id, patientItem.getP_id());
            values.put(PatientContract.PatientEntry.COLUMN_p_serv_id, patientItem.getId());
            values.put(PatientContract.PatientEntry.COLUMN_patientName, patientItem.getPatientName());
            values.put(PatientContract.PatientEntry.COLUMN_occup, patientItem.getOccup());
            values.put(PatientContract.PatientEntry.COLUMN_info, patientItem.getInfo());
            values.put(PatientContract.PatientEntry.COLUMN_weight, patientItem.getWeight());
            values.put(PatientContract.PatientEntry.COLUMN_age, patientItem.getAge());
            values.put(PatientContract.PatientEntry.COLUMN_flag, patientItem.getFlag());

            Uri newUri = mContext.getContentResolver().insert(PatientContract.PatientEntry.CONTENT_URI, values);
        }
 }
    @Override
    public  void addPatientsFromServerToLocal(List<PatientItem> dataSet,Context mContext)
    {
        for (int i=0;i<dataSet.size();i++) {
            PatientItem patientItem=dataSet.get(i);
            ContentValues values = new ContentValues();
            values.put(PatientContract.PatientEntry.COLUMN_p_id, patientItem.getP_id());
            values.put(PatientContract.PatientEntry.COLUMN_p_serv_id, patientItem.getId());
            values.put(PatientContract.PatientEntry.COLUMN_patientName, patientItem.getPatientName());
            values.put(PatientContract.PatientEntry.COLUMN_occup, patientItem.getOccup());
            values.put(PatientContract.PatientEntry.COLUMN_info, patientItem.getInfo());
            values.put(PatientContract.PatientEntry.COLUMN_weight, patientItem.getWeight());
            values.put(PatientContract.PatientEntry.COLUMN_age, patientItem.getAge());
            values.put(PatientContract.PatientEntry.COLUMN_flag, patientItem.getFlag());

            Uri newUri = mContext.getContentResolver().insert(PatientContract.PatientEntry.CONTENT_URI, values);
        }
    }

    @Override
    public void filterPatientsResult(String text,List<PatientItem> dataSet)
    {
        //patientListView.showPatients(allPatientData);
        ArrayList<PatientItem> filterdNames = new ArrayList<>();
        if (text.isEmpty())
            patientListView.showSearchResult(dataSet);
        //looping through existing elements
        for (PatientItem s : dataSet) {
            //if the existing elements contains the search input
            if (s.getPatientName().toLowerCase().contains(text.toLowerCase())||s.getP_id().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);

            }
        }
        patientListView.showSearchResult(filterdNames);
    }


    //implement from Interactor
    @Override
    public void onPatientRetreivesSucessfull(Context context ,List<PatientItem> allPatientData)
    {
        patientListView.showPatients(allPatientData);
    }

    @Override
    public void onPatientsRetreiveFailure(Context context ,List<PatientItem> allPatientData)
    {
        patientListView.showPatients(allPatientData);
    }
}
