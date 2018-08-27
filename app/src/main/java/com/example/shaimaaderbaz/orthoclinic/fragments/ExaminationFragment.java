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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.ExaminationItem;
import com.example.shaimaaderbaz.orthoclinic.models.Info;
import com.example.shaimaaderbaz.orthoclinic.presenter.ExaminationPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.ExaminationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

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

    @BindView(R.id.trauma_layout)
    LinearLayout trauma_layout;
    @BindView(R.id.linear_select_image_trauma)
    LinearLayout linear_select_image_trauma;
    @BindView(R.id.linear_select_vedio_trauma)
    LinearLayout linear_select_vedio_trauma;

    @BindView(R.id.knee_layout)
    LinearLayout knee_layout;
    @BindView(R.id.linear_select_image_knee)
    LinearLayout linear_select_image_knee;
    @BindView(R.id.linear_select_vedio_knee)
    LinearLayout linear_select_vedio_knee;

    @BindView(R.id.shoulder_layout)
    LinearLayout shoulder_layout;
    @BindView(R.id.linear_select_image_shoulder)
    LinearLayout linear_select_image_shoulder;
    @BindView(R.id.linear_select_vedio_shoulder)
    LinearLayout linear_select_vedio_shoulder;

    @BindView(R.id.sqine_layout)
    LinearLayout sqine_layout;
    @BindView(R.id.linear_select_image_sqine)
    LinearLayout linear_select_image_sqine;
    @BindView(R.id.linear_select_vedio_sqine)
    LinearLayout linear_select_vedio_sqine;

    @BindView(R.id.pelvis_layout)
    LinearLayout pelvis_layout;
    @BindView(R.id.linear_select_image_pelvis)
    LinearLayout linear_select_image_pelvis;
    @BindView(R.id.linear_select_vedio_pelvis)
    LinearLayout linear_select_vedio_pelvis;

    @BindView(R.id.anke_layout)
    LinearLayout anke_layout;
    @BindView(R.id.linear_select_image_anke)
    LinearLayout linear_select_image_anke;
    @BindView(R.id.linear_select_vedio_anke)
    LinearLayout linear_select_vedio_anke;

    @BindView(R.id.elbow_layout)
    LinearLayout elbow_layout;
    @BindView(R.id.linear_select_image_elbow)
    LinearLayout linear_select_image_elbow;
    @BindView(R.id.linear_select_vedio_elbow)
    LinearLayout linear_select_vedio_elbow;

    @BindView(R.id.wrist_layout)
    LinearLayout wrist_layout;
    @BindView(R.id.linear_select_image_wrist)
    LinearLayout linear_select_image_wrist;
    @BindView(R.id.linear_select_vedio_wrist)
    LinearLayout linear_select_vedio_wrist;
    @BindView(R.id.progress)
    ProgressBar mProgress;


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
        presenter = new ExaminationPresenterImp(this,this.getContext());
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

                String traumaInfo=trauma_text1.getText().toString();

                String kneeInfo=knee_text1.getText().toString();

                String shoulderInfo=shoulder_text1.getText().toString();

                String sqineInfo=sqine_text1.getText().toString();

                String pelvisInfo=pelvis_text1.getText().toString();

                String ankeInfo=anke_text1.getText().toString();

                String elbowInfo=elbow_text1.getText().toString();

                String wristInfo=wrist_text1.getText().toString();

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
                presenter.addExaminationToServer(examinationItem,mPatientId);
                mProgress.setVisibility(View.VISIBLE);
            }
        });


        return view;
    }

    @Override
    public void setExaminationCreateSucessfull(Context context)
    {
        mProgress.setVisibility(View.GONE);
        Toast.makeText(context, "Examination Added Sucessfully", Toast.LENGTH_SHORT).show();
    }

    @OnCheckedChanged(R.id.trauma_check)
    void onTraumaCheckChanged(){
        if(trauma_check.isChecked())
        {
            trauma_layout.setVisibility(View.VISIBLE);
            //linear_select_image_trauma.setVisibility(View.VISIBLE);
            //linear_select_vedio_trauma.setVisibility(View.VISIBLE);
        }
        else {
            trauma_layout.setVisibility(View.GONE);
            linear_select_image_trauma.setVisibility(View.GONE);
            linear_select_vedio_trauma.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.knee_check)
    void onKneeCheckChanged(){
        if(knee_check.isChecked())
        {
            knee_layout.setVisibility(View.VISIBLE);
            //linear_select_image_knee.setVisibility(View.VISIBLE);
            //linear_select_vedio_knee.setVisibility(View.VISIBLE);
        }
        else {
            knee_layout.setVisibility(View.GONE);
            linear_select_image_knee.setVisibility(View.GONE);
            linear_select_vedio_knee.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.shoulder_check)
    void onShoulderCheckChanged(){
        if(shoulder_check.isChecked())
        {
            shoulder_layout.setVisibility(View.VISIBLE);
            //linear_select_image_shoulder.setVisibility(View.VISIBLE);
            //linear_select_vedio_shoulder.setVisibility(View.VISIBLE);
        }
        else {
            shoulder_layout.setVisibility(View.GONE);
            linear_select_image_shoulder.setVisibility(View.GONE);
            linear_select_vedio_shoulder.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.sqine_check)
    void onSqineCheckChanged(){
        if(sqine_check.isChecked())
        {
            sqine_layout.setVisibility(View.VISIBLE);
            //linear_select_image_sqine.setVisibility(View.VISIBLE);
            //linear_select_vedio_sqine.setVisibility(View.VISIBLE);
        }
        else {
            sqine_layout.setVisibility(View.GONE);
            linear_select_image_sqine.setVisibility(View.GONE);
            linear_select_vedio_sqine.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.pelvis_check)
    void onPelvisCheckChanged(){
        if(pelvis_check.isChecked())
        {
            pelvis_layout.setVisibility(View.VISIBLE);
            //linear_select_image_pelvis.setVisibility(View.VISIBLE);
            //linear_select_vedio_pelvis.setVisibility(View.VISIBLE);
        }
        else {
            pelvis_layout.setVisibility(View.GONE);
            linear_select_image_pelvis.setVisibility(View.GONE);
            linear_select_vedio_pelvis.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.anke_check)
    void onAnkeCheckChanged(){
        if(anke_check.isChecked())
        {
            anke_layout.setVisibility(View.VISIBLE);
            //linear_select_image_anke.setVisibility(View.VISIBLE);
            //linear_select_vedio_anke.setVisibility(View.VISIBLE);
        }
        else {
            anke_layout.setVisibility(View.GONE);
            linear_select_image_anke.setVisibility(View.GONE);
            linear_select_vedio_anke.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.elbow_check)
    void onElbowCheckChanged(){
        if(elbow_check.isChecked())
        {
            elbow_layout.setVisibility(View.VISIBLE);
            //linear_select_image_elbow.setVisibility(View.VISIBLE);
            //linear_select_vedio_elbow.setVisibility(View.VISIBLE);
        }
        else {
            elbow_layout.setVisibility(View.GONE);
            linear_select_image_elbow.setVisibility(View.GONE);
            linear_select_vedio_elbow.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.wrist_check)
    void onWristCheckChanged(){
        if(wrist_check.isChecked())
        {
            wrist_layout.setVisibility(View.VISIBLE);
            //linear_select_image_wrist.setVisibility(View.VISIBLE);
            //linear_select_vedio_wrist.setVisibility(View.VISIBLE);
        }
        else {
            wrist_layout.setVisibility(View.GONE);
            linear_select_image_wrist.setVisibility(View.GONE);
            linear_select_vedio_wrist.setVisibility(View.GONE);
        }
    }


}
