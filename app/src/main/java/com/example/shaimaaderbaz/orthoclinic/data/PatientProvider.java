package com.example.shaimaaderbaz.orthoclinic.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Shaimaa Derbaz on 10/2/2018.
 */

public class PatientProvider extends ContentProvider {
    private OrthoDbHelper mObHelper;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {

        sUriMatcher.addURI("com.example.shaimaaderbaz.orthoclinic.patient", "patients", 100);
        sUriMatcher.addURI("com.example.shaimaaderbaz.orthoclinic.patient", "patients/#", 101);
    }
    @Override
    public boolean onCreate()
    {
        mObHelper=new OrthoDbHelper(getContext());
        return true;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        SQLiteDatabase database=mObHelper.getReadableDatabase();
        Cursor cursor;
        switch (sUriMatcher.match(uri)) {
            case 100:
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = "_ID ASC";
                cursor=database.query(PatientContract.PatientEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case 101:
                selection = PatientContract.PatientEntry._ID + "=?";
                selectionArgs=new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor=database.query(PatientContract.PatientEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;

            default:
              cursor=null;
        }
        return cursor;
    }
    public Uri insertPatient(Uri uri, ContentValues contentValues)
    {
        SQLiteDatabase database = mObHelper.getWritableDatabase();

        //validation
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_p_id))
        {
            String name = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_p_id);
            if (name == null) {
                throw new IllegalArgumentException("requires p id");
            }
        }

        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_p_serv_id)) {
            Integer price = contentValues.getAsInteger(PatientContract.PatientEntry.COLUMN_p_serv_id);
            if (price != null && price < 0) {
                throw new IllegalArgumentException("requires p_serv_id");
            }
        }

        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_patientName)) {
            Integer quantity = contentValues.getAsInteger(PatientContract.PatientEntry.COLUMN_patientName);
            if (quantity != null && quantity < 0) {
                throw new IllegalArgumentException("requires patient name");
            }
        }
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_occup))
        {
        String supplierName = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_occup);
        if (supplierName == null) {
            throw new IllegalArgumentException("requires a name");
        }
        }
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_info))
        {
            String supplierName = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_info);
            if (supplierName == null) {
                throw new IllegalArgumentException("requires a info");
            }
        }
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_created_date))
        {
            String supplierName = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_created_date);
            if (supplierName == null) {
                throw new IllegalArgumentException("requires a info");
            }
        }
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_updated_date))
        {
            String supplierName = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_updated_date);
            if (supplierName == null) {
                throw new IllegalArgumentException("requires a info");
            }
        }
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_age))
        {
            String supplierName = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_age);
            if (supplierName == null) {
                throw new IllegalArgumentException("requires a info");
            }
        }
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_weight))
        {
            String supplierName = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_weight);
            if (supplierName == null) {
                throw new IllegalArgumentException("requires a info");
            }
        }
        if (contentValues.containsKey(PatientContract.PatientEntry.COLUMN_flag))
        {
            String supplierName = contentValues.getAsString(PatientContract.PatientEntry.COLUMN_flag);
            if (supplierName == null) {
                throw new IllegalArgumentException("requires a info");
            }
        }

        // Insert the new product with the given values
        long id = database.insert(PatientContract.PatientEntry.TABLE_NAME, null, contentValues);
        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1) {
            Log.e(" ", "Failed to insert row for " + uri);
            return null;
        }


        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (sUriMatcher.match(uri)) {
            case 100:
               return insertPatient(uri,contentValues);
            default:
                throw new IllegalArgumentException("not supported "+uri);
        }

    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs)
    {
        return 0;
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database = mObHelper.getWritableDatabase();

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case 100:
                // Delete all rows that match the selection and selection args
                return database.delete(PatientContract.PatientEntry.TABLE_NAME, selection, selectionArgs);
            case 101:
                selection = PatientContract.PatientEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return database.delete(PatientContract.PatientEntry.TABLE_NAME, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }
    }
    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case 100:
                return PatientContract.PatientEntry.CONTENT_LIST_TYPE;
            case 10:
                return PatientContract.PatientEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }
}
