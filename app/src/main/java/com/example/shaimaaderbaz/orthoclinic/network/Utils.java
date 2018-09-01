package com.example.shaimaaderbaz.orthoclinic.network;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public class Utils {


    public static final String BASE_URL = "http://c82eb137.ngrok.io";


    public static OrthoAPI getOrthoAPI() {
        return RetrofitClient.getClient(BASE_URL).create(OrthoAPI.class);
    }
}
