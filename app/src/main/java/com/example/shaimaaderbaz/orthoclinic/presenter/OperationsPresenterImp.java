package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.views.OperationsView;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class OperationsPresenterImp implements OperationsPresenter ,OperationsInteractor.OnAddOperationsFinishedListener {

    private OperationsView operationsView;
    public OperationsPresenterImp(OperationsView operationsView)
    {
        this.operationsView=operationsView;
    }
    // implement from Presenter
    @Override
    public void addOperationsToServer(OperationsItem operationsItem) {
        //Save user to database on Server

    }
    //implement from Interactor
    @Override
    public void onOperationsCreateSucessfull(Context context)
    {
        operationsView.setOperationsCreateSucessfull(context);
    }
    @Override
    public void onOperationsCreateFailure(Context context)
    {
        operationsView.setOperationsCreateFailure(context);
    }
}
