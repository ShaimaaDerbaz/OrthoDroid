package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPreferencesRepository;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPrefsRepositoryImpl;
import com.example.shaimaaderbaz.orthoclinic.views.ExaminationView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class ExaminationPresenterImp implements ExaminationPresenter ,ExaminationInteractor.OnAddExaminationFinishedListener ,BaseResponseCall {

    private ExaminationView examinationView;
    private Context mContext;
    private SharedPreferencesRepository mSharedPrefrencesRepository;
    public ExaminationPresenterImp(ExaminationView examinationView,Context context)
    {
        this.examinationView=examinationView;
        this.mSharedPrefrencesRepository = new SharedPrefsRepositoryImpl(
                context.getApplicationContext());
        mContext=context;
    }
    // implement from Presenter
    @Override
    public void addExaminationToServer(ExaminationItem examinationItem, int patientId) {
        //Save user to database on Server
        ArrayList<RetrofitModels.Complain> complainList
                = new ArrayList<>();
        if(examinationItem.getTrauma()) {
            String info = examinationItem.getTraumaInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.trauma)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }

        if(examinationItem.getKnee()) {
            String info = examinationItem.getKneeInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.knee)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }

        if(examinationItem.getShoulder()) {
            String info = examinationItem.getShoulderInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.shoulder)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }

        if(examinationItem.getSqine()) {
            String info = examinationItem.getSqineInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.sqine)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }

        if(examinationItem.getPelvis()) {
            String info = examinationItem.getPelvisInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.pelvis)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }
        if(examinationItem.getAnkefoot()) {
            String info = examinationItem.getAnkefootInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.anke)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }
        if(examinationItem.getElbow()) {
            String info = examinationItem.getElbowInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.elbow)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }
        if(examinationItem.getWrist()) {
            String info = examinationItem.getWristInfo();
            int id = mSharedPrefrencesRepository.getSpecificComplain(
                    mContext.getString(R.string.wrist)
            );
            complainList.add(new RetrofitModels.Complain(id,info));
        }
        HashMap<String,Integer> map = mSharedPrefrencesRepository.getAllComplains();
        DataCalls dataCalls = new DataCalls();
        dataCalls.addComplain(complainList,patientId,this);

    }
    //implement from Interactor
    @Override
    public void onExaminationCreateSucessfull(Context context)
    {
        examinationView.setExaminationCreateSucessfull(context);
    }

    @Override
    public void success() {
        examinationView.setExaminationCreateSucessfull(mContext);
    }

    @Override
    public void error(String message) {

    }
}
