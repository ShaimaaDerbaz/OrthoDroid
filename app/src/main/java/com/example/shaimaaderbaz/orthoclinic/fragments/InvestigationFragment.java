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
import com.example.shaimaaderbaz.orthoclinic.models.Info;
import com.example.shaimaaderbaz.orthoclinic.models.InvestigationItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.InvestigationPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.InvestigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaimaa Derbaz on 7/30/2018.
 */

public class InvestigationFragment extends Fragment implements InvestigationView{
    InvestigationPresenterImp presenter;
    Context context;
    @BindView(R.id.chemistry_check)
    AppCompatCheckBox chemistry_check;
    @BindView(R.id.chemisty_text1)
    EditText chemisty_text1;

    @BindView(R.id.cls_check)
    AppCompatCheckBox cls_check;
    @BindView(R.id.cls_text1)
    EditText cls_text1;

    @BindView(R.id.cutology_check)
    AppCompatCheckBox cytology_check;
    @BindView(R.id.cutology_text1)
    EditText cytology_text1;

    @BindView(R.id.xray_check)
    AppCompatCheckBox xray_check;
    @BindView(R.id.xray_text1)
    EditText xray_text1;

    @BindView(R.id.scanogram_check)
    AppCompatCheckBox scanogram_check;
    @BindView(R.id.scanogram_text1)
    EditText scanogram_text1;

    @BindView(R.id.ct_check)
    AppCompatCheckBox ct_check;
    @BindView(R.id.ct_text1)
    EditText ct_text1;

    @BindView(R.id.mrt_check)
    AppCompatCheckBox mri_check;
    @BindView(R.id.mrt_text1)
    EditText mri_text1;

    @BindView(R.id.dexa_check)
    AppCompatCheckBox dexa_check;
    @BindView(R.id.dexa_text1)
    EditText dexa_text1;

    @BindView(R.id.bone_check)
    AppCompatCheckBox bone_check;
    @BindView(R.id.bone_text1)
    EditText bone_text1;

    @BindView(R.id.btnAddInv)
    Button btnAddInv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_profile_invistigation, container, false);
        presenter = new InvestigationPresenterImp(this);
        context=getContext();
        ButterKnife.bind(this,view);
        btnAddInv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                InvestigationItem investigationItem = new InvestigationItem();
                Boolean chemistry=chemistry_check.isChecked();
                Boolean cls=cls_check.isChecked();
                Boolean cytology=cytology_check.isChecked();
                Boolean xray=xray_check.isChecked();
                Boolean scanogram=scanogram_check.isChecked();
                Boolean ct=ct_check.isChecked();
                Boolean mri=mri_check.isChecked();
                Boolean dexa=dexa_check.isChecked();
                Boolean bone=bone_check.isChecked();

                Info chemistryInfo=new Info();
                chemistryInfo.setInfo1(chemisty_text1.getText().toString());

                Info clsInfo=new Info();
                clsInfo.setInfo1(cls_text1.getText().toString());

                Info cytologyInfo=new Info();
                cytologyInfo.setInfo1(cytology_text1.getText().toString());

                Info xrayInfo=new Info();
                xrayInfo.setInfo1(xray_text1.getText().toString());

                Info scanogramInfo=new Info();
                scanogramInfo.setInfo1(scanogram_text1.getText().toString());

                Info ctInfo=new Info();
                ctInfo.setInfo1(ct_text1.getText().toString());

                Info mriInfo=new Info();
                mriInfo.setInfo1(mri_text1.getText().toString());

                Info dexaInfo=new Info();
                dexaInfo.setInfo1(dexa_text1.getText().toString());

                Info boneInfo=new Info();
                boneInfo.setInfo1(bone_text1.getText().toString());

                investigationItem.setChemistry(chemistry);
                investigationItem.setChemistryInfo(chemistryInfo);
                investigationItem.setCls(cls);
                investigationItem.setClsInfo(clsInfo);
                investigationItem.setCytology(cytology);
                investigationItem.setCytologyInfo(cytologyInfo);
                investigationItem.setXray(xray);
                investigationItem.setXrayInfo(xrayInfo);
                investigationItem.setScanogram(scanogram);
                investigationItem.setScanogramInfo(scanogramInfo);
                investigationItem.setCt(ct);
                investigationItem.setCtInfo(ctInfo);
                investigationItem.setMri(mri);
                investigationItem.setMriInfo(mriInfo);
                investigationItem.setDexa(dexa);
                investigationItem.setDexaInfo(dexaInfo);
                investigationItem.setBonescan(bone);
                investigationItem.setBonescanInfo(boneInfo);

                presenter.addInvestigationToServer(investigationItem);
                presenter.onInvestigationCreateSucessfull(context);
            }
        });



        return view;
    }
    @Override
    public void setInvestigationCreateSucessfull (Context context)
    {
        Toast.makeText(context, "Investigation Added Sucessfully", Toast.LENGTH_SHORT).show();
    }
}
