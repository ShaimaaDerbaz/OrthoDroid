package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.views.ExaminationView;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class ExaminationPresenterImp implements ExaminationPresenter ,ExaminationInteractor.OnAddExaminationFinishedListener {

    private ExaminationView examinationView;
    public ExaminationPresenterImp(ExaminationView examinationView)
    {
        this.examinationView=examinationView;
    }
    // implement from Presenter
    @Override
    public void addExaminationToServer(ExaminationItem examinationItem) {
        //Save user to database on Server

    }
    //implement from Interactor
    @Override
    public void onExaminationCreateSucessfull(Context context)
    {
        examinationView.setExaminationCreateSucessfull(context);
    }
}
