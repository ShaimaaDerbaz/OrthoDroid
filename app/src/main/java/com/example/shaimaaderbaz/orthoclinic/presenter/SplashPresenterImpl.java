package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.AllDataCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPreferencesRepository;
import com.example.shaimaaderbaz.orthoclinic.views.SplashView;

import java.util.HashMap;

public class SplashPresenterImpl implements SplashPresenter {

    private SplashView mView;

    private SharedPreferencesRepository mSharedPreferencesRepository;

    public SplashPresenterImpl(SplashView splashView,SharedPreferencesRepository spr) {
        mView = splashView;
        mSharedPreferencesRepository = spr;
    }

    @Override
    public void bindAllData() {
        DataCalls dataCalls = new DataCalls();
        dataCalls.getAllData(new AllDataCall() {
            @Override
            public void success(RetrofitModels.AllDataResponse items) {
                addResponseToSharedPrefs(items);
                mView.onDataReturned();
            }

            @Override
            public void error(String error) {
                mView.onError();
            }
        });
    }

    private void addResponseToSharedPrefs(RetrofitModels.AllDataResponse items) {
        HashMap<String,Integer> complainsMap = new HashMap<>();
        HashMap<String,Integer> historyMap = new HashMap<>();
        HashMap<String,Integer> radiationsMap = new HashMap<>();
        HashMap<String,Integer> labsMap = new HashMap<>();

        if(items != null) {
            for (RetrofitModels.Complain complain : items.getmComplains()) {
                complainsMap.put(complain.getName(), complain.getId());
            }

            for (RetrofitModels.MedicalHistory history : items.getmMedicalHistory()) {
                historyMap.put(history.getName(), history.getId());
            }

            for (RetrofitModels.Radiation radiation : items.getmRadiations()) {
                radiationsMap.put(radiation.getName(), radiation.getId());
            }

            for (RetrofitModels.Lab lab : items.getmLabs()) {
                labsMap.put(lab.getName(), lab.getId());
            }
        }
        mSharedPreferencesRepository.clearRepos();
        mSharedPreferencesRepository.saveComplains(complainsMap);
        mSharedPreferencesRepository.saveHistory(historyMap);
        mSharedPreferencesRepository.saveLabs(labsMap);
        mSharedPreferencesRepository.saveRadiations(radiationsMap);

    }
}
