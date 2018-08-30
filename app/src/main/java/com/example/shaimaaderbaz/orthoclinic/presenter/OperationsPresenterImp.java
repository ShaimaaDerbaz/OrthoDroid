package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.OperationsView;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class OperationsPresenterImp implements OperationsPresenter,
        OperationsInteractor.OnAddOperationsFinishedListener,
        BaseResponseCall{

    private OperationsView operationsView;
    public OperationsPresenterImp(OperationsView operationsView)
    {
        this.operationsView=operationsView;
    }
    // implement from Presenter
    @Override
    public void addOperationsToServer(OperationsItem operationsItem, int patinetId) {
        DataCalls dataCalls = new DataCalls();
        dataCalls.addOperation(new RetrofitModels.Operation(
                operationsItem.getName(),
                operationsItem.getSteps(),
                operationsItem.getDate(),
                operationsItem.getPersons(),
                operationsItem.getFollow_up()
        ),patinetId,this);
    }
    @Override
    public void updateOperationsToServer(OperationsItem operationsItem, int patientId)
    {
        DataCalls dataCalls = new DataCalls();
        dataCalls.updateOperation(new RetrofitModels.Operation(
                operationsItem.getName(),
                operationsItem.getSteps(),
                operationsItem.getDate(),
                operationsItem.getPersons(),
                operationsItem.getFollow_up()
        ),patientId,this);
    }
    //implement from Interactor
    @Override
    public void onOperationsCreateSucessfull()
    {
        operationsView.setOperationsCreateSucessfull();
    }
    @Override
    public void onOperationsCreateFailure()
    {
        operationsView.setOperationsCreateFailure();
    }

    @Override
    public void success() {
        operationsView.setOperationsCreateSucessfull();
    }

    @Override
    public void error(String message) {
        operationsView.setOperationsCreateFailure();
    }
}
