package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaimaaderbaz.orthoclinic.R;

public class ContactUsActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, ContactUsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }
}
