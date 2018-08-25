package com.example.shaimaaderbaz.orthoclinic.network;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Shaimaa Derbaz on 8/24/2018.
 */

public interface OrthoAPI {

  //  @POST("movie/popular")
  //  Call<BaseResponse<HistoryItem>> saveHistory(@Field("page") int page, @Field("api_key") String apiKey);
    @GET("/api/patients")
    Call<AllPatientData> getAllPatients();
}
