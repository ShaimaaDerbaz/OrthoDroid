package com.example.shaimaaderbaz.orthoclinic.fragments;

/**
 * Created by Shaimaa Derbaz on 7/29/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileExaminationAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileHistoryAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileInvestigationLabsAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileInvestigationRadiationsAdapter;
import com.example.shaimaaderbaz.orthoclinic.models.AllPatientInfoData;
import com.example.shaimaaderbaz.orthoclinic.models.PersonalItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.PatientPersonalPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.PatientPersonalView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public  class PersonalFragment extends Fragment implements PatientPersonalView{

    private static final String TAG = "personal_tab_fragment";

    @BindView(R.id.recyclerViewItemHistory)
    RecyclerView historyRecyclerview;
    @BindView(R.id.recyclerViewItemExamination)
    RecyclerView examinationRecyclerview;
    @BindView(R.id.recyclerViewItemInvestigationLabs)
    RecyclerView investigationLabRecyclerView;
    @BindView(R.id.recyclerViewItemInvestigationRads)
    RecyclerView investigationRadsRecyclerView;


    List<PersonalItem> allHistory;
    List<PersonalItem> allExaminations;
    PatientProfileHistoryAdapter patientProfileHistoryAdapter;
    PatientProfileExaminationAdapter patientProfileExaminationAdapter;
    PatientProfileInvestigationLabsAdapter patientProfileInvestigationLabsAdapter;
    PatientProfileInvestigationRadiationsAdapter patientProfileInvestigationRadiationsAdapter;
    PatientPersonalPresenterImp presenter =new PatientPersonalPresenterImp(this);


    public PersonalFragment() {
    }

    private int mPatientId;
    private static final String PATIENT_KEY = "patient_key";

    public static PersonalFragment newInstance(int patientID) {
        PersonalFragment fragment = new PersonalFragment();
        Bundle args = new Bundle();
        args.putInt(PATIENT_KEY, patientID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().getInt(PATIENT_KEY,0) != 0)
            mPatientId = getArguments().getInt(PATIENT_KEY);
        else
            throw new RuntimeException("Invalid Patient ID");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_profile_personal, container, false);
        presenter =new PatientPersonalPresenterImp(this);
        presenter.retreivePatientInfoFromServer(mPatientId);
        ButterKnife.bind(this,view);
        allHistory = new ArrayList<>();
        PersonalItem historyItem =new PersonalItem() ;
        historyItem.setStatusName("Lactation");
        historyItem.setInfo("test");

        allExaminations = new ArrayList<>();
        PersonalItem examinationItem =new PersonalItem() ;
        examinationItem.setStatusName("Knee");
        examinationItem.setInfo("test");

        for (int i=0;i<3;i++)
        {
            allHistory.add(historyItem) ;
        }
        for (int i=0;i<3;i++)
        {
            allExaminations.add(examinationItem) ;
        }
        //historyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        //patientProfileHistoryAdapter = new PatientProfileHistoryAdapter(getContext(),allHistory);
        //historyRecyclerview.setAdapter(patientProfileHistoryAdapter);
        //examinationRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        //patientProfileExaminationAdapter = new PatientProfileExaminationAdapter(getContext(),allExaminations);
        //examinationRecyclerview.setAdapter(patientProfileExaminationAdapter);
        return view;
    }
    @Override
    public void showPatientInfo(AllPatientInfoData allPatientInfoData ,int patient_id)
    {
        historyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        patientProfileHistoryAdapter = new PatientProfileHistoryAdapter(getContext(),allPatientInfoData.getMedical_history());
        historyRecyclerview.setAdapter(patientProfileHistoryAdapter);
        examinationRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        patientProfileExaminationAdapter = new PatientProfileExaminationAdapter(getContext(),allPatientInfoData.getComplains());
        examinationRecyclerview.setAdapter(patientProfileExaminationAdapter);
        investigationLabRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        patientProfileInvestigationLabsAdapter = new PatientProfileInvestigationLabsAdapter(getContext(),allPatientInfoData.getLabs());
        investigationLabRecyclerView.setAdapter(patientProfileInvestigationLabsAdapter);
        investigationRadsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        patientProfileInvestigationRadiationsAdapter = new PatientProfileInvestigationRadiationsAdapter(getContext(),allPatientInfoData.getRadiations());
        investigationRadsRecyclerView.setAdapter(patientProfileInvestigationRadiationsAdapter);
    }

    }

