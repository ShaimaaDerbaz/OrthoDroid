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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.activities.EditItemActivity;
import com.example.shaimaaderbaz.orthoclinic.activities.EditOperationActivity;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileExaminationAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileHistoryAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileInvestigationLabsAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileInvestigationRadiationsAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileOperationsAdapter;
import com.example.shaimaaderbaz.orthoclinic.models.AllPatientInfoData;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PersonalItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.PatientPersonalPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.PatientPersonalView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public  class PersonalFragment extends Fragment implements PatientPersonalView ,PatientProfileOperationsAdapter.PatientProfileAdapterListener,PatientProfileInvestigationRadiationsAdapter.PatientProfileRadiationsAdapterListener{

    private static final String TAG = "personal_tab_fragment";

    @BindView(R.id.recyclerViewItemHistory)
    RecyclerView historyRecyclerview;
    @BindView(R.id.recyclerViewItemExamination)
    RecyclerView examinationRecyclerview;
    @BindView(R.id.recyclerViewItemInvestigationLabs)
    RecyclerView investigationLabRecyclerView;
    @BindView(R.id.recyclerViewItemInvestigationRads)
    RecyclerView investigationRadsRecyclerView;
    @BindView(R.id.recyclerViewItemOperations)
    RecyclerView operationsRecyclerView;

    @BindView(R.id.name_personal_text)
    TextView name_personal_text;
    @BindView(R.id.id_personal_text)
    TextView id_personal_text;
    @BindView(R.id.age_personal_text)
    TextView age_personal_text;
    @BindView(R.id.occup_personal_text)
    TextView occup_personal_text;
    @BindView(R.id.weight_personal_text)
    TextView weight_personal_text;
    @BindView(R.id.info_personal_text)
    TextView info_personal_text;
    @BindView(R.id.progress)
    ProgressBar mProgress;


    PatientProfileHistoryAdapter patientProfileHistoryAdapter;
    PatientProfileExaminationAdapter patientProfileExaminationAdapter;
    PatientProfileInvestigationLabsAdapter patientProfileInvestigationLabsAdapter;
    PatientProfileInvestigationRadiationsAdapter patientProfileInvestigationRadiationsAdapter;
    PatientProfileOperationsAdapter patientProfileOperationsAdapter;
    PatientPersonalPresenterImp presenter =new PatientPersonalPresenterImp(this);
    static OperationsItem operationsItem ;
    static RadiationItem radiationItem ;
    static AllPatientInfoData allPatientInfoDataG;
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
        ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void showPatientInfo(AllPatientInfoData allPatientInfoData ,int patient_id)
    {
        mProgress.setVisibility(View.GONE);
        id_personal_text.setText(allPatientInfoData.getPatient().getId());
        name_personal_text.setText(allPatientInfoData.getPatient().getPatientName());
        occup_personal_text.setText(allPatientInfoData.getPatient().getOccup());
        age_personal_text.setText(allPatientInfoData.getPatient().getAge()+"");
        weight_personal_text.setText(allPatientInfoData.getPatient().getWeight()+"");
        info_personal_text.setText(allPatientInfoData.getPatient().getInfo());
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
        patientProfileInvestigationRadiationsAdapter = new PatientProfileInvestigationRadiationsAdapter(getContext(),allPatientInfoData.getRadiations(),this);
        investigationRadsRecyclerView.setAdapter(patientProfileInvestigationRadiationsAdapter);
        operationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        patientProfileOperationsAdapter = new PatientProfileOperationsAdapter(getContext(),allPatientInfoData.getOperations(),this);
        operationsRecyclerView.setAdapter(patientProfileOperationsAdapter);
        allPatientInfoDataG=allPatientInfoData;

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.retreivePatientInfoFromServer(mPatientId);
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClicked(int id,int adapterPos)
    {
        operationsItem=allPatientInfoDataG.getOperations().get(adapterPos);
        EditOperationActivity.start(getContext(),id,operationsItem);
    }
    @Override
    public void onItemRadiationClicked(int id,int adapterPos)
    {
        radiationItem=allPatientInfoDataG.getRadiations().get(adapterPos);
        EditItemActivity.start(getContext(),id,radiationItem);
      //  EditItemActivity.start(getContext(),id,operationsItem);
    }

}

