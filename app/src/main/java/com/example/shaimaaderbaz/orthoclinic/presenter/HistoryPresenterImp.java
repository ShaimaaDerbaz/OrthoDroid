package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPreferencesRepository;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPrefsRepositoryImpl;
import com.example.shaimaaderbaz.orthoclinic.views.HistoryView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class HistoryPresenterImp implements HistoryPresenter,
        BaseResponseCall
{

    private HistoryView historyView;
    private Context mContext;
    private SharedPreferencesRepository mSharedPrefrencesRepository;
    public HistoryPresenterImp(HistoryView historyView,
                               Context context)
    {
        this.historyView=historyView;
        this.mSharedPrefrencesRepository = new SharedPrefsRepositoryImpl(
                context.getApplicationContext());
        this.mContext = context;
    }
    // implement from AddPatientPresenter
    @Override
    public void addHistoryToServer(HistoryItem historyItem, int patientId) {
        ArrayList<RetrofitModels.MedicalHistory> historyList
                = new ArrayList<>();
        if(historyItem.isCh()) {
            String info = historyItem.getChInfo();
            int id = mSharedPrefrencesRepository.getSpecificHistoryId(
                   mContext.getString(R.string.ch)
            );
            historyList.add(new RetrofitModels.MedicalHistory(id,info));
        }

        if(historyItem.isGastritis()) {
            String info = historyItem.getGastritisInfo();
            int id = mSharedPrefrencesRepository.getSpecificHistoryId(
                    mContext.getString(R.string.gastritis)
            );
            historyList.add(new RetrofitModels.MedicalHistory(id,info));
        }

        if(historyItem.isLactation()) {
            String info = historyItem.getLactationInfo();
            int id = mSharedPrefrencesRepository.getSpecificHistoryId(
                    mContext.getString(R.string.lactation)
            );
            historyList.add(new RetrofitModels.MedicalHistory(id,info));
        }

        if(historyItem.isPregnecy()) {
            String info = historyItem.getPregnecyInfo();
            int id = mSharedPrefrencesRepository.getSpecificHistoryId(
                    mContext.getString(R.string.pregnancy)
            );
            historyList.add(new RetrofitModels.MedicalHistory(id,info));
        }

        if(historyItem.isSmoking()) {
            String info = historyItem.getSmokingInfo();
            int id = mSharedPrefrencesRepository.getSpecificHistoryId(
                    mContext.getString(R.string.smoking)
            );
            historyList.add(new RetrofitModels.MedicalHistory(id,info));
        }
        HashMap<String,Integer> map = mSharedPrefrencesRepository.getAllHistory();
        DataCalls dataCalls = new DataCalls();
        dataCalls.addMedicalHistory(historyList,patientId,this);
    }

    @Override
    public void success() {
        historyView.setHistoryCreateSucessfull();
    }

    @Override
    public void error(String message) {

    }
}
