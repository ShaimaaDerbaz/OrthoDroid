package com.example.shaimaaderbaz.orthoclinic.fragments;

import android.content.Context;
import android.os.Bundle;
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
    @BindView(R.id.trauma_text2)
    EditText trauma_text2;
    @BindView(R.id.trauma_text3)
    EditText trauma_text3;
    @BindView(R.id.trauma_text4)
    EditText trauma_text4;

    @BindView(R.id.knee_check)
    AppCompatCheckBox knee_check;
    @BindView(R.id.knee_text1)
    EditText knee_text1;
    @BindView(R.id.knee_text2)
    EditText knee_text2;
    @BindView(R.id.knee_text3)
    EditText knee_text3;
    @BindView(R.id.knee_text4)
    EditText knee_text4;

    @BindView(R.id.shoulder_check)
    AppCompatCheckBox shoulder_check;
    @BindView(R.id.shoulder_text1)
    EditText shoulder_text1;
    @BindView(R.id.shoulder_text2)
    EditText shoulder_text2;
    @BindView(R.id.shoulder_text3)
    EditText shoulder_text3;
    @BindView(R.id.shoulder_text4)
    EditText shoulder_text4;

    @BindView(R.id.sqine_check)
    AppCompatCheckBox sqine_check;
    @BindView(R.id.sqine_text1)
    EditText sqine_text1;
    @BindView(R.id.sqine_text2)
    EditText sqine_text2;
    @BindView(R.id.sqine_text3)
    EditText sqine_text3;
    @BindView(R.id.sqine_text4)
    EditText sqine_text4;

    @BindView(R.id.pelvis_check)
    AppCompatCheckBox pelvis_check;
    @BindView(R.id.pelvis_text1)
    EditText pelvis_text1;
    @BindView(R.id.pelvis_text2)
    EditText pelvis_text2;
    @BindView(R.id.pelvis_text3)
    EditText pelvis_text3;
    @BindView(R.id.pelvis_text4)
    EditText pelvis_text4;

    @BindView(R.id.anke_check)
    AppCompatCheckBox anke_check;
    @BindView(R.id.anke_text1)
    EditText anke_text1;
    @BindView(R.id.anke_text2)
    EditText anke_text2;
    @BindView(R.id.anke_text3)
    EditText anke_text3;
    @BindView(R.id.anke_text4)
    EditText anke_text4;

    @BindView(R.id.elbow_check)
    AppCompatCheckBox elbow_check;
    @BindView(R.id.elbow_text1)
    EditText elbow_text1;
    @BindView(R.id.elbow_text2)
    EditText elbow_text2;
    @BindView(R.id.elbow_text3)
    EditText elbow_text3;
    @BindView(R.id.elbow_text4)
    EditText elbow_text4;

    @BindView(R.id.wrist_check)
    AppCompatCheckBox wrist_check;
    @BindView(R.id.wrist_text1)
    EditText wrist_text1;
    @BindView(R.id.wrist_text2)
    EditText wrist_text2;
    @BindView(R.id.wrist_text3)
    EditText wrist_text3;
    @BindView(R.id.wrist_text4)
    EditText wrist_text4;
    @BindView(R.id.btnAddEx)
    Button btnAddEx;
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
                traumaInfo.setInfo2(trauma_text2.getText().toString());
                traumaInfo.setInfo3(trauma_text3.getText().toString());
                traumaInfo.setInfo4(trauma_text4.getText().toString());

                Info kneeInfo=new Info();
                kneeInfo.setInfo1(knee_text1.getText().toString());
                kneeInfo.setInfo2(knee_text2.getText().toString());
                kneeInfo.setInfo3(knee_text3.getText().toString());
                kneeInfo.setInfo4(knee_text4.getText().toString());

                Info shoulderInfo=new Info();
                shoulderInfo.setInfo1(shoulder_text1.getText().toString());
                shoulderInfo.setInfo2(shoulder_text2.getText().toString());
                shoulderInfo.setInfo3(shoulder_text3.getText().toString());
                shoulderInfo.setInfo4(shoulder_text4.getText().toString());

                Info sqineInfo=new Info();
                sqineInfo.setInfo1(sqine_text1.getText().toString());
                sqineInfo.setInfo2(sqine_text2.getText().toString());
                sqineInfo.setInfo3(sqine_text3.getText().toString());
                sqineInfo.setInfo4(sqine_text4.getText().toString());

                Info pelvisInfo=new Info();
                pelvisInfo.setInfo1(pelvis_text1.getText().toString());
                pelvisInfo.setInfo2(pelvis_text2.getText().toString());
                pelvisInfo.setInfo3(pelvis_text3.getText().toString());
                pelvisInfo.setInfo4(pelvis_text4.getText().toString());

                Info ankeInfo=new Info();
                ankeInfo.setInfo1(anke_text1.getText().toString());
                ankeInfo.setInfo2(anke_text2.getText().toString());
                ankeInfo.setInfo3(anke_text3.getText().toString());
                ankeInfo.setInfo4(anke_text4.getText().toString());

                Info elbowInfo=new Info();
                elbowInfo.setInfo1(elbow_text1.getText().toString());
                elbowInfo.setInfo2(elbow_text2.getText().toString());
                elbowInfo.setInfo3(elbow_text3.getText().toString());
                elbowInfo.setInfo4(elbow_text4.getText().toString());

                Info wristInfo=new Info();
                wristInfo.setInfo1(wrist_text1.getText().toString());
                wristInfo.setInfo2(wrist_text2.getText().toString());
                wristInfo.setInfo3(wrist_text3.getText().toString());
                wristInfo.setInfo4(wrist_text4.getText().toString());


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
