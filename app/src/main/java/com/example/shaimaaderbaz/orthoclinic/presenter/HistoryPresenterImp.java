package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;
import com.example.shaimaaderbaz.orthoclinic.views.HistoryView;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class HistoryPresenterImp implements HistoryPresenter ,HistoryInteractor.OnAddHistoryFinishedListener {

    private HistoryView historyView;
    public HistoryPresenterImp(HistoryView historyView)
    {
        this.historyView=historyView;
    }
    // implement from AddPatientPresenter
    @Override
    public void addHistoryToServer(HistoryItem historyItem) {
        //Save user to database on Server

    }
    //implement from AddPatientInteractor
    @Override
    public void onHistoryCreateSucessfull(Context context)
    {
        historyView.setHistoryCreateSucessfull(context);
    }
}
