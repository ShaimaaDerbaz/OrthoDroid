package com.example.shaimaaderbaz.orthoclinic.network;

import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;

public interface AllDataCall {
    void success(RetrofitModels.AllDataResponse items);

    void error(String error);
}
