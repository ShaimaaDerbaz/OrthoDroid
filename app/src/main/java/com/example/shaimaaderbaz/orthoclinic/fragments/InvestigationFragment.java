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
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.Info;
import com.example.shaimaaderbaz.orthoclinic.models.InvestigationItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.InvestigationPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.InvestigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

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

    @BindView(R.id.chemistry_layout)
    LinearLayout chemistry_layout;
    @BindView(R.id.linear_select_image_ch)
    LinearLayout linear_select_image_ch;
    @BindView(R.id.linear_select_vedio_ch)
    LinearLayout linear_select_vedio_ch;

    @BindView(R.id.cls_layout)
    LinearLayout cls_layout;
    @BindView(R.id.linear_select_image_cls)
    LinearLayout linear_select_image_cls;
    @BindView(R.id.linear_select_vedio_cls)
    LinearLayout linear_select_vedio_cls;

    @BindView(R.id.cutology_layout)
    LinearLayout cutology_layout;
    @BindView(R.id.linear_select_image_cut)
    LinearLayout linear_select_image_cut;
    @BindView(R.id.linear_select_vedio_cut)
    LinearLayout linear_select_vedio_cut;

    @BindView(R.id.xray_layout)
    LinearLayout xray_layout;
    @BindView(R.id.linear_select_image_xray)
    LinearLayout linear_select_image_xray;
    @BindView(R.id.linear_select_vedio_xray)
    LinearLayout linear_select_vedio_xray;

    @BindView(R.id.scanogram_layout)
    LinearLayout scanogram_layout;
    @BindView(R.id.linear_select_image_scan)
    LinearLayout linear_select_image_scan;
    @BindView(R.id.linear_select_vedio_scan)
    LinearLayout linear_select_vedio_scan;

    @BindView(R.id.ct_layout)
    LinearLayout ct_layout;
    @BindView(R.id.linear_select_image_ct)
    LinearLayout linear_select_image_ct;
    @BindView(R.id.linear_select_vedio_ct)
    LinearLayout linear_select_vedio_ct;

    @BindView(R.id.mrt_layout)
    LinearLayout mrt_layout;
    @BindView(R.id.linear_select_image_mrt)
    LinearLayout linear_select_image_mrt;
    @BindView(R.id.linear_select_vedio_mrt)
    LinearLayout linear_select_vedio_mrt;

    @BindView(R.id.dexa_layout)
    LinearLayout dexa_layout;
    @BindView(R.id.linear_select_image_dexa)
    LinearLayout linear_select_image_dexa;
    @BindView(R.id.linear_select_vedio_dexa)
    LinearLayout linear_select_vedio_dexa;

    @BindView(R.id.bone_layout)
    LinearLayout bone_layout;
    @BindView(R.id.linear_select_image_bone)
    LinearLayout linear_select_image_bone;
    @BindView(R.id.linear_select_vedio_bone)
    LinearLayout linear_select_vedio_bone;


    private int mPatientId;
    private static final String PATIENT_KEY = "patient_key";

    public static InvestigationFragment newInstance(int patientID) {
        InvestigationFragment fragment = new InvestigationFragment();
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
        View view = inflater.inflate(R.layout.fragment_patient_profile_invistigation, container, false);
        presenter = new InvestigationPresenterImp(this,this.getContext());
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

                String chemistryInfo=chemisty_text1.getText().toString();

                String clsInfo=cls_text1.getText().toString();

                String cytologyInfo=cytology_text1.getText().toString();

                String xrayInfo=xray_text1.getText().toString();

                String scanogramInfo=scanogram_text1.getText().toString();

                String ctInfo=ct_text1.getText().toString();

                String mriInfo=mri_text1.getText().toString();

                String dexaInfo=dexa_text1.getText().toString();

                String boneInfo=bone_text1.getText().toString();

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

                presenter.addInvestigationToServer(investigationItem,mPatientId);
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

    @OnCheckedChanged(R.id.chemistry_check)
    void onChemistryCheckChanged(){
        if(chemistry_check.isChecked())
        {
            chemistry_layout.setVisibility(View.VISIBLE);
            linear_select_image_ch.setVisibility(View.VISIBLE);
            linear_select_vedio_ch.setVisibility(View.VISIBLE);
        }
        else {
            chemistry_layout.setVisibility(View.GONE);
            linear_select_image_ch.setVisibility(View.GONE);
            linear_select_vedio_ch.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.cls_check)
    void onClsCheckChanged(){
        if(cls_check.isChecked())
        {
            cls_layout.setVisibility(View.VISIBLE);
            linear_select_image_cls.setVisibility(View.VISIBLE);
            linear_select_vedio_cls.setVisibility(View.VISIBLE);
        }
        else {
            cls_layout.setVisibility(View.GONE);
            linear_select_image_cls.setVisibility(View.GONE);
            linear_select_vedio_cls.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.cutology_check)
    void onCutologyCheckChanged(){
        if(cytology_check.isChecked())
        {
            cutology_layout.setVisibility(View.VISIBLE);
            linear_select_image_cut.setVisibility(View.VISIBLE);
            linear_select_vedio_cut.setVisibility(View.VISIBLE);
        }
        else {
            cutology_layout.setVisibility(View.GONE);
            linear_select_image_cut.setVisibility(View.GONE);
            linear_select_vedio_cut.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.xray_check)
    void onXrayCheckChanged(){
        if(xray_check.isChecked())
        {
            xray_layout.setVisibility(View.VISIBLE);
            linear_select_image_xray.setVisibility(View.VISIBLE);
            linear_select_vedio_xray.setVisibility(View.VISIBLE);
        }
        else {
            xray_layout.setVisibility(View.GONE);
            linear_select_image_xray.setVisibility(View.GONE);
            linear_select_vedio_xray.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.scanogram_check)
    void onScanogramCheckChanged(){
        if(scanogram_check.isChecked())
        {
            scanogram_layout.setVisibility(View.VISIBLE);
            linear_select_image_scan.setVisibility(View.VISIBLE);
            linear_select_vedio_scan.setVisibility(View.VISIBLE);
        }
        else {
            scanogram_layout.setVisibility(View.GONE);
            linear_select_image_scan.setVisibility(View.GONE);
            linear_select_vedio_scan.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.ct_check)
    void onCtCheckChanged(){
        if(ct_check.isChecked())
        {
            ct_layout.setVisibility(View.VISIBLE);
            linear_select_image_ct.setVisibility(View.VISIBLE);
            linear_select_vedio_ct.setVisibility(View.VISIBLE);
        }
        else {
            ct_layout.setVisibility(View.GONE);
            linear_select_image_ct.setVisibility(View.GONE);
            linear_select_vedio_ct.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.mrt_check)
    void onMRICheckChanged(){
        if(mri_check.isChecked())
        {
            mrt_layout.setVisibility(View.VISIBLE);
            linear_select_image_mrt.setVisibility(View.VISIBLE);
            linear_select_vedio_mrt.setVisibility(View.VISIBLE);
        }
        else {
            mrt_layout.setVisibility(View.GONE);
            linear_select_image_mrt.setVisibility(View.GONE);
            linear_select_vedio_mrt.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.dexa_check)
    void onDexaCheckChanged(){
        if(dexa_check.isChecked())
        {
            dexa_layout.setVisibility(View.VISIBLE);
            linear_select_image_dexa.setVisibility(View.VISIBLE);
            linear_select_vedio_dexa.setVisibility(View.VISIBLE);
        }
        else {
            dexa_layout.setVisibility(View.GONE);
            linear_select_image_dexa.setVisibility(View.GONE);
            linear_select_vedio_dexa.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.bone_check)
    void onBoneCheckChanged(){
        if(bone_check.isChecked())
        {
            bone_layout.setVisibility(View.VISIBLE);
            linear_select_image_bone.setVisibility(View.VISIBLE);
            linear_select_vedio_bone.setVisibility(View.VISIBLE);
        }
        else {
            bone_layout.setVisibility(View.GONE);
            linear_select_image_bone.setVisibility(View.GONE);
            linear_select_vedio_bone.setVisibility(View.GONE);
        }
    }
}
