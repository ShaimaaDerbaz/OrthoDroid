package com.example.shaimaaderbaz.orthoclinic.network;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public class Utils {

    public static final String BASE_URL = "http://576ae2fa.ngrok.io/";

    public static OrthoAPI getOrthoAPI() {
        return RetrofitClient.getClient(BASE_URL).create(OrthoAPI.class);
    }
}
