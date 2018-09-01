package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaimaaderbaz.orthoclinic.R;

public class EditItemActivity extends AppCompatActivity {

   /* public static void start(Context context, int patientId, OperationsItem operationsItemO) {
        Intent starter = new Intent(context, EditOperationActivity.class);
        starter.putExtra(PATIENT_ID_KEY, patientId);
        starter.putExtra(operationsItem, operationsItemO);
        context.startActivity(starter);
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
    }
}
