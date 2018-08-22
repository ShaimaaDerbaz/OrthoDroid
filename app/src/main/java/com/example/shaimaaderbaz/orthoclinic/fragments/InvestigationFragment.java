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
    @BindView(R.id.chemisty_text2)
    EditText chemisty_text2;
    @BindView(R.id.chemisty_text3)
    EditText chemisty_text3;
    @BindView(R.id.chemisty_text4)
    EditText chemisty_text4;

    @BindView(R.id.cls_check)
    AppCompatCheckBox cls_check;
    @BindView(R.id.cls_text1)
    EditText cls_text1;
    @BindView(R.id.cls_text2)
    EditText cls_text2;
    @BindView(R.id.cls_text3)
    EditText cls_text3;
    @BindView(R.id.cls_text4)
    EditText cls_text4;

    @BindView(R.id.cutology_check)
    AppCompatCheckBox cytology_check;
    @BindView(R.id.cutology_text1)
    EditText cytology_text1;
    @BindView(R.id.cutology_text2)
    EditText cytology_text2;
    @BindView(R.id.cutology_text3)
    EditText cytology_text3;
    @BindView(R.id.cutology_text4)
    EditText cytology_text4;

    @BindView(R.id.xray_check)
    AppCompatCheckBox xray_check;
    @BindView(R.id.xray_text1)
    EditText xray_text1;
    @BindView(R.id.xray_text2)
    EditText xray_text2;
    @BindView(R.id.xray_text3)
    EditText xray_text3;
    @BindView(R.id.xray_text4)
    EditText xray_text4;

    @BindView(R.id.scanogram_check)
    AppCompatCheckBox scanogram_check;
    @BindView(R.id.scanogram_text1)
    EditText scanogram_text1;
    @BindView(R.id.scanogram_text2)
    EditText scanogram_text2;
    @BindView(R.id.scanogram_text3)
    EditText scanogram_text3;
    @BindView(R.id.scanogram_text4)
    EditText scanogram_text4;

    @BindView(R.id.ct_check)
    AppCompatCheckBox ct_check;
    @BindView(R.id.ct_text1)
    EditText ct_text1;
    @BindView(R.id.ct_text2)
    EditText ct_text2;
    @BindView(R.id.ct_text3)
    EditText ct_text3;
    @BindView(R.id.ct_text4)
    EditText ct_text4;

    @BindView(R.id.mrt_check)
    AppCompatCheckBox mri_check;
    @BindView(R.id.mrt_text1)
    EditText mri_text1;
    @BindView(R.id.mrt_text2)
    EditText mri_text2;
    @BindView(R.id.mrt_text3)
    EditText mri_text3;
    @BindView(R.id.mrt_text4)
    EditText mri_text4;

    @BindView(R.id.dexa_check)
    AppCompatCheckBox dexa_check;
    @BindView(R.id.dexa_text1)
    EditText dexa_text1;
    @BindView(R.id.dexa_text2)
    EditText dexa_text2;
    @BindView(R.id.dexa_text3)
    EditText dexa_text3;
    @BindView(R.id.dexa_text4)
    EditText dexa_text4;

    @BindView(R.id.bone_check)
    AppCompatCheckBox bone_check;
    @BindView(R.id.bone_text1)
    EditText bone_text1;
    @BindView(R.id.bone_text2)
    EditText bone_text2;
    @BindView(R.id.bone_text3)
    EditText bone_text3;
    @BindView(R.id.bone_text4)
    EditText bone_text4;
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
                chemistryInfo.setInfo2(chemisty_text2.getText().toString());
                chemistryInfo.setInfo3(chemisty_text3.getText().toString());
                chemistryInfo.setInfo4(chemisty_text4.getText().toString());

                Info clsInfo=new Info();
                clsInfo.setInfo1(cls_text1.getText().toString());
                clsInfo.setInfo2(cls_text2.getText().toString());
                clsInfo.setInfo3(cls_text3.getText().toString());
                clsInfo.setInfo4(cls_text4.getText().toString());

                Info cytologyInfo=new Info();
                cytologyInfo.setInfo1(cytology_text1.getText().toString());
                cytologyInfo.setInfo2(cytology_text2.getText().toString());
                cytologyInfo.setInfo3(cytology_text3.getText().toString());
                cytologyInfo.setInfo4(cytology_text4.getText().toString());

                Info xrayInfo=new Info();
                xrayInfo.setInfo1(xray_text1.getText().toString());
                xrayInfo.setInfo2(xray_text2.getText().toString());
                xrayInfo.setInfo3(xray_text3.getText().toString());
                xrayInfo.setInfo4(xray_text4.getText().toString());

                Info scanogramInfo=new Info();
                scanogramInfo.setInfo1(scanogram_text1.getText().toString());
                scanogramInfo.setInfo2(scanogram_text2.getText().toString());
                scanogramInfo.setInfo3(scanogram_text3.getText().toString());
                scanogramInfo.setInfo4(scanogram_text4.getText().toString());

                Info ctInfo=new Info();
                ctInfo.setInfo1(ct_text1.getText().toString());
                ctInfo.setInfo2(ct_text2.getText().toString());
                ctInfo.setInfo3(ct_text3.getText().toString());
                ctInfo.setInfo4(ct_text4.getText().toString());

                Info mriInfo=new Info();
                mriInfo.setInfo1(mri_text1.getText().toString());
                mriInfo.setInfo2(mri_text2.getText().toString());
                mriInfo.setInfo3(mri_text3.getText().toString());
                mriInfo.setInfo4(mri_text4.getText().toString());

                Info dexaInfo=new Info();
                dexaInfo.setInfo1(dexa_text1.getText().toString());
                dexaInfo.setInfo2(dexa_text2.getText().toString());
                dexaInfo.setInfo3(dexa_text3.getText().toString());
                dexaInfo.setInfo4(dexa_text4.getText().toString());

                Info boneInfo=new Info();
                boneInfo.setInfo1(bone_text1.getText().toString());
                boneInfo.setInfo2(bone_text2.getText().toString());
                boneInfo.setInfo3(bone_text3.getText().toString());
                boneInfo.setInfo4(bone_text4.getText().toString());


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
