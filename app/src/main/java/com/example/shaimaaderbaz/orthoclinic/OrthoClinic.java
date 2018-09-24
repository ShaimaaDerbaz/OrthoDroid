package com.example.shaimaaderbaz.orthoclinic;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class OrthoClinic extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
