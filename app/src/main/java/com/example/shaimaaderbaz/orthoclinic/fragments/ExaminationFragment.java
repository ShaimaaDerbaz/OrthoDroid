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
import android.widget.EditText;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.Info;
import com.example.shaimaaderbaz.orthoclinic.presenter.ExaminationPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.ExaminationView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaimaa Derbaz on 7/30/2018.
 */

public class ExaminationFragment extends Fragment implements ExaminationView{
    ExaminationPresenterImp presenter;
    Context context;

    @BindView(R.id.trauma_check)
    AppCompatCheckBox trauma_check;
    @BindView(R.id.trauma_text1)
    EditText trauma_text1;

    @BindView(R.id.knee_check)
    AppCompatCheckBox knee_check;
    @BindView(R.id.knee_text1)
    EditText knee_text1;

    @BindView(R.id.shoulder_check)
    AppCompatCheckBox shoulder_check;
    @BindView(R.id.shoulder_text1)
    EditText shoulder_text1;

    @BindView(R.id.sqine_check)
    AppCompatCheckBox sqine_check;
    @BindView(R.id.sqine_text1)
    EditText sqine_text1;

    @BindView(R.id.pelvis_check)
    AppCompatCheckBox pelvis_check;
    @BindView(R.id.pelvis_text1)
    EditText pelvis_text1;

    @BindView(R.id.anke_check)
    AppCompatCheckBox anke_check;
    @BindView(R.id.anke_text1)
    EditText anke_text1;

    @BindView(R.id.elbow_check)
    AppCompatCheckBox elbow_check;
    @BindView(R.id.elbow_text1)
    EditText elbow_text1;

    @BindView(R.id.wrist_check)
    AppCompatCheckBox wrist_check;
    @BindView(R.id.wrist_text1)
    EditText wrist_text1;

    @BindView(R.id.btnAddEx)
    Button btnAddEx;

    private int mPatientId;
    private static final String PATIENT_KEY = "patient_key";

    public static ExaminationFragment newInstance(int patientID) {
        ExaminationFragment fragment = new ExaminationFragment();
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
        View view = inflater.inflate(R.layout.fragment_patient_profile_examination, container, false);
        presenter = new ExaminationPresenterImp(this);
        context=getContext();
        ButterKnife.bind(this,view);
        btnAddEx.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ExaminationItem examinationItem = new ExaminationItem();
                Boolean trauma=trauma_check.isChecked();
                Boolean knee=knee_check.isChecked();
                Boolean shoulder=shoulder_check.isChecked();
                Boolean sqine=sqine_check.isChecked();
                Boolean pelvis=pelvis_check.isChecked();
                Boolean anke=anke_check.isChecked();
                Boolean elbow=elbow_check.isChecked();
                Boolean wrist=wrist_check.isChecked();

                Info traumaInfo=new Info();
                traumaInfo.setInfo1(trauma_text1.getText().toString());

                Info kneeInfo=new Info();
                kneeInfo.setInfo1(knee_text1.getText().toString());

                Info shoulderInfo=new Info();
                shoulderInfo.setInfo1(shoulder_text1.getText().toString());

                Info sqineInfo=new Info();
                sqineInfo.setInfo1(sqine_text1.getText().toString());

                Info pelvisInfo=new Info();
                pelvisInfo.setInfo1(pelvis_text1.getText().toString());

                Info ankeInfo=new Info();
                ankeInfo.setInfo1(anke_text1.getText().toString());

                Info elbowInfo=new Info();
                elbowInfo.setInfo1(elbow_text1.getText().toString());

                Info wristInfo=new Info();
                wristInfo.setInfo1(wrist_text1.getText().toString());

                examinationItem.setTrauma(trauma);
                examinationItem.setTraumaInfo(traumaInfo);
                examinationItem.setKnee(knee);
                examinationItem.setKneeInfo(kneeInfo);
                examinationItem.setShoulder(shoulder);
                examinationItem.setShoulderInfo(shoulderInfo);
                examinationItem.setSqine(sqine);
                examinationItem.setSqineInfo(sqineInfo);
                examinationItem.setPelvis(pelvis);
                examinationItem.setSqineInfo(pelvisInfo);
                examinationItem.setAnkefoot(anke);
                examinationItem.setAnkefootInfo(ankeInfo);
                examinationItem.setElbow(elbow);
                examinationItem.setElbowInfo(elbowInfo);
                examinationItem.setWrist(wrist);
                examinationItem.setWristInfo(wristInfo);
                presenter.addExaminationToServer(examinationItem);
                presenter.onExaminationCreateSucessfull(context);
            }
        });


        return view;
    }

    @Override
    public void setExaminationCreateSucessfull(Context context)
    {
        Toast.makeText(context, "Examination Added Sucessfully", Toast.LENGTH_SHORT).show();
    }
}
