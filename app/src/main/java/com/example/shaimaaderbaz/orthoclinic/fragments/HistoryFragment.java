package com.example.shaimaaderbaz.orthoclinic.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.HistoryPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.HistoryView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaimaa Derbaz on 7/29/2018.
 */

public class HistoryFragment  extends Fragment implements HistoryView {
    private static final String PATIENT_ID_KEY = "patient_key";

    HistoryPresenterImp presenter;
    Context context;
    @BindView(R.id.ch_check)
    AppCompatCheckBox ch_check;
    @BindView(R.id.ch_text)
    EditText ch_text;
    @BindView(R.id.smoking_check)
    AppCompatCheckBox smoking_check;
    @BindView(R.id.somking_text)
    EditText smoking_text;
    @BindView(R.id.gastritis_check)
    AppCompatCheckBox gastritis_check;
    @BindView(R.id.gastritis_text)
    EditText gastritis_text;
    @BindView(R.id.pregnacy_check)
    AppCompatCheckBox pregnacy_check;
    @BindView(R.id.pregnacy_text)
    EditText pregnacy_text;
    @BindView(R.id.lactation_check)
    AppCompatCheckBox lactation_check;
    @BindView(R.id.lactation_text)
    EditText lactation_text;
    @BindView(R.id.btnAddHistory)
    Button btnAddHistory;

    private int mPatientId;
    private static final String PATIENT_KEY = "patient_key";

    public static HistoryFragment newInstance(int patientID) {
        HistoryFragment fragment = new HistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_patient_profile_history, container, false);
        presenter = new HistoryPresenterImp(this);
        context=getContext();
        ButterKnife.bind(this,view);
        btnAddHistory.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                HistoryItem historyItem = new HistoryItem();
                Boolean ch=ch_check.isChecked();
                Boolean smoking=smoking_check.isChecked();
                Boolean gastritis=gastritis_check.isChecked();
                Boolean pregnacy=pregnacy_check.isChecked();
                Boolean lactation=lactation_check.isChecked();
                String chInfo=ch_text.getText().toString();
                String smokingInfo=smoking_text.getText().toString();
                String gastritisInfo=gastritis_text.getText().toString();
                String pregnacyInfo=pregnacy_text.getText().toString();
                String lactationInfo=lactation_text.getText().toString();
                historyItem.setCh(ch);
                historyItem.setGastritis(gastritis);
                historyItem.setSmoking(smoking);
                historyItem.setPregnecy(pregnacy);
                historyItem.setLactation(lactation);
                historyItem.setChInfo(chInfo);
                historyItem.setGastritisInfo(gastritisInfo);
                historyItem.setSmokingInfo(smokingInfo);
                historyItem.setPregnecyInfo(pregnacyInfo);
                historyItem.setLactationInfo(lactationInfo);
                presenter.addHistoryToServer(historyItem);
                presenter.onHistoryCreateSucessfull(context);
            }
        });

        return view;
    }

    @Override
    public void setHistoryCreateSucessfull (Context context)
    {
        Toast.makeText(context, "History Added Sucessfully", Toast.LENGTH_SHORT).show();
    }
}
