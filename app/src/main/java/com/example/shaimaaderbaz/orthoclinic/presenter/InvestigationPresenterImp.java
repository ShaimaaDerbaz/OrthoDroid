package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.InvestigationItem;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPreferencesRepository;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPrefsRepositoryImpl;
import com.example.shaimaaderbaz.orthoclinic.views.InvestigationView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public class InvestigationPresenterImp implements InvestigationPresenter ,InvestigationInteractor.OnAddInvestigationFinishedListener ,BaseResponseCall {

    private InvestigationView investigationView;
    private Context mContext;
    private SharedPreferencesRepository mSharedPrefrencesRepository;
    public InvestigationPresenterImp(InvestigationView investigationView,Context context)
    {
        this.investigationView=investigationView;
        this.mSharedPrefrencesRepository = new SharedPrefsRepositoryImpl(
                context.getApplicationContext());
        mContext=context;
    }
    // implement from Presenter
    @Override
    public void addInvestigationToServer(InvestigationItem investigationItem ,int patientId) {
        //Save user to database on Server
        ArrayList<RetrofitModels.Lab> labList
                = new ArrayList<>();
        ArrayList<RetrofitModels.Radiation> radiationList
                = new ArrayList<>();
        if(investigationItem.getChemistry()) {
            String info = investigationItem.getChemistryInfo();
            int id = mSharedPrefrencesRepository.getSpecificLab(
                    mContext.getString(R.string.chemistry)
            );
            labList.add(new RetrofitModels.Lab(id,info));
        }
        if(investigationItem.getCls()) {
            String info = investigationItem.getClsInfo();
            int id = mSharedPrefrencesRepository.getSpecificLab(
                    mContext.getString(R.string.cls)
            );
            labList.add(new RetrofitModels.Lab(id,info));
        }

        if(investigationItem.getCytology()) {
            String info = investigationItem.getCytologyInfo();
            int id = mSharedPrefrencesRepository.getSpecificLab(
                    mContext.getString(R.string.cytology)
            );
            labList.add(new RetrofitModels.Lab(id,info));
        }

        if(investigationItem.getXray()) {
            String info = investigationItem.getXrayInfo();
            int id = mSharedPrefrencesRepository.getSpecificRadiation(
                    mContext.getString(R.string.xray)
            );
            radiationList.add(new RetrofitModels.Radiation(id,info));
        }

        if(investigationItem.getScanogram()) {
            String info = investigationItem.getScanogramInfo();
            int id = mSharedPrefrencesRepository.getSpecificRadiation(
                    mContext.getString(R.string.scanogram)
            );
            radiationList.add(new RetrofitModels.Radiation(id,info));
        }
        if(investigationItem.getCt()) {
            String info = investigationItem.getCtInfo();
            int id = mSharedPrefrencesRepository.getSpecificRadiation(
                    mContext.getString(R.string.ct)
            );
            radiationList.add(new RetrofitModels.Radiation(id,info));
        }
        if(investigationItem.getMri()) {
            String info = investigationItem.getMriInfo();
            int id = mSharedPrefrencesRepository.getSpecificRadiation(
                    mContext.getString(R.string.mri)
            );
            radiationList.add(new RetrofitModels.Radiation(id,info));
        }
        if(investigationItem.getDexa()) {
            String info = investigationItem.getDexaInfo();
            int id = mSharedPrefrencesRepository.getSpecificRadiation(
                    mContext.getString(R.string.dexa)
            );
            radiationList.add(new RetrofitModels.Radiation(id,info));
        }
        if(investigationItem.getBonescan()) {
            String info = investigationItem.getBonescanInfo();
            int id = mSharedPrefrencesRepository.getSpecificRadiation(
                    mContext.getString(R.string.bonescan)
            );
            radiationList.add(new RetrofitModels.Radiation(id,info));
        }

        HashMap<String,Integer> map = mSharedPrefrencesRepository.getAllLabs();
        DataCalls dataCalls = new DataCalls();
        dataCalls.addLab(labList,patientId,this);
        dataCalls.addRadiation(radiationList,patientId,this);


    }
    //implement from Interactor
    @Override
    public void onInvestigationCreateSucessfull(Context context)
    {
        investigationView.setInvestigationCreateSucessfull(context);
    }

    @Override
    public void success() {
        investigationView.setInvestigationCreateSucessfull(mContext);
    }

    @Override
    public void error(String message) {

    }
}
