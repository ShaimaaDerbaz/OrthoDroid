package com.example.shaimaaderbaz.orthoclinic.fragments;

/**
 * Created by Shaimaa Derbaz on 7/29/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileExaminationAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientProfileHistoryAdapter;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.HistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public  class PersonalFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "personal_tab_fragment";

    @BindView(R.id.recyclerViewItemHistory)
    RecyclerView historyRecyclerview;
    @BindView(R.id.recyclerViewItemExamination)
    RecyclerView examinationRecyclerview;

    List<HistoryItem> allHistory;
    List<ExaminationItem> allExaminations;
    PatientProfileHistoryAdapter patientProfileHistoryAdapter;
    PatientProfileExaminationAdapter patientProfileExaminationAdapter;
    public PersonalFragment() {
    }


    public static PersonalFragment newInstance(int sectionNumber) {
        PersonalFragment fragment = new PersonalFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_profile_personal, container, false);
        ButterKnife.bind(this,view);
        allHistory = new ArrayList<>();
        HistoryItem historyItem =new HistoryItem() ;
        historyItem.setCh(true);
        historyItem.setGastritis(false);
        historyItem.setSmoking(true);
        historyItem.setPregnecy(true);
        historyItem.setLactation(false);

        allExaminations = new ArrayList<>();
        ExaminationItem examinationItem =new ExaminationItem() ;
        examinationItem.setTrauma(true);
        examinationItem.setShoulder(false);
        examinationItem.setKnee(true);
        examinationItem.setSqine(true);
        examinationItem.setPelvis(true);
        examinationItem.setAnkefoot(false);
        examinationItem.setElbow(true);
        examinationItem.setWrist(false);

        for (int i=0;i<3;i++)
        {
            allHistory.add(historyItem) ;
        }
        for (int i=0;i<3;i++)
        {
            allExaminations.add(examinationItem) ;
        }
        historyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        patientProfileHistoryAdapter = new PatientProfileHistoryAdapter(getContext(),allHistory);
        historyRecyclerview.setAdapter(patientProfileHistoryAdapter);
        examinationRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        patientProfileExaminationAdapter = new PatientProfileExaminationAdapter(getContext(),allExaminations);
        examinationRecyclerview.setAdapter(patientProfileExaminationAdapter);
        //TextView textView = (TextView) view.findViewById(R.id.text_personal);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
       // textView.setText("Text personal");
        return view;
    }
}
