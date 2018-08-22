package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.InvestigationItem;
import com.example.shaimaaderbaz.orthoclinic.views.InvestigationView;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class InvestigationPresenterImp implements InvestigationPresenter ,InvestigationInteractor.OnAddInvestigationFinishedListener {

    private InvestigationView investigationView;
    public InvestigationPresenterImp(InvestigationView investigationView)
    {
        this.investigationView=investigationView;
    }
    // implement from Presenter
    @Override
    public void addInvestigationToServer(InvestigationItem investigationItem) {
        //Save user to database on Server

    }
    //implement from Interactor
    @Override
    public void onInvestigationCreateSucessfull(Context context)
    {
        investigationView.setInvestigationCreateSucessfull(context);
    }
}
