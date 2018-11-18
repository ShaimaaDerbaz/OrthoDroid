package com.example.shaimaaderbaz.orthoclinic.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shaimaa Derbaz on 10/2/2018.
 */

public class OrthoDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final String SQL_CREATE_PATEINT_ENTRIES =
            "CREATE TABLE " + PatientContract.PatientEntry.TABLE_NAME + " (" +
                    PatientContract.PatientEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PatientContract.PatientEntry.COLUMN_p_serv_id + " INTEGER," +
                    PatientContract.PatientEntry.COLUMN_p_id + " INTEGER NOT NULL," +
                    PatientContract.PatientEntry.COLUMN_patientName + " TEXT NOT NULL," +
                    PatientContract.PatientEntry.COLUMN_occup + " TEXT NOT NULL," +
                    PatientContract.PatientEntry.COLUMN_info + " TEXT NOT NULL," +
                    PatientContract.PatientEntry.COLUMN_created_date + " TEXT," +
                    PatientContract.PatientEntry.COLUMN_updated_date + " TEXT," +
                    PatientContract.PatientEntry.COLUMN_age + " INTEGER NOT NULL," +
                    PatientContract.PatientEntry.COLUMN_weight + " INTEGER,"+
                    PatientContract.PatientEntry.COLUMN_weight + " INTEGER NOT NULL);";

    private static final String SQL_CREATE_LOGIN_ENTRIES =
            "CREATE TABLE " + UserLoginContract.UserLoginEntry.TABLE_NAME + " (" +
                    UserLoginContract.UserLoginEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    UserLoginContract.UserLoginEntry.COLUMN_Username + " TEXT NOT NULL," +
                    UserLoginContract.UserLoginEntry.COLUMN_Password + " TEXT NOT NULL);";



    private static final String SQL_DELETE_PATIENT_ENTRIES =
            "DROP TABLE IF EXISTS " + PatientContract.PatientEntry.TABLE_NAME;
    private static final String SQL_DELETE_LOGIN_ENTRIES =
            "DROP TABLE IF EXISTS " + UserLoginContract.UserLoginEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "OrthoInv.db";

    public OrthoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_PATEINT_ENTRIES);
        db.execSQL(SQL_CREATE_LOGIN_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PATIENT_ENTRIES);
        onCreate(db);
        db.execSQL(SQL_DELETE_LOGIN_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}