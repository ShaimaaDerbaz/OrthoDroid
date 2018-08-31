package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaimaaderbaz.orthoclinic.R;

public class EditOperationActivity extends AppCompatActivity {
    private static final String PATIENT_ID_KEY = "patient_id";

    public static void start(Context context, int patientId) {
        Intent starter = new Intent(context, EditOperationActivity.class);
        starter.putExtra(PATIENT_ID_KEY,patientId);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_operation);
    }
}
