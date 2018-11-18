package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;
import android.database.Cursor;

import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

/**
 * Created by Shaimaa Derbaz on 10/21/2018.
 */

public interface LoginPresenter {

    void addUserAndPassToLog(String username,String password);
    void addUserAndPassToDatabase(String username,String password ,Context mContext);
    Cursor retrieveLoginDataFromDatabase(Context mContext);
}


