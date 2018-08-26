package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.AddPatientPresenter;
import com.example.shaimaaderbaz.orthoclinic.presenter.AddPatientPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddPatientActivity extends AppCompatActivity implements AddPatientView{
    private AddPatientPresenterImp presenter;
    private Context context;
    @BindView(R.id.etPatientAge)
    EditText patientAgeEt;
    @BindView(R.id.etPatientName)
    EditText patientNameEt;
    @BindView(R.id.etOccupation)
    EditText occupationEt;
    @BindView(R.id.etPatientWeight)
    EditText patientWeightEt;
    @BindView(R.id.etPatientInfo)
    EditText patientInfoEt;
    @BindView(R.id.btnCreateProfile)
    Button btnCreateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        presenter = new AddPatientPresenterImp(this);
        context=this;
        ButterKnife.bind(this);
        btnCreateProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                PatientItem patientItem = new PatientItem();
                String patientAge=patientAgeEt.getText().toString();
                String patientName=patientNameEt.getText().toString();
                String occupation=occupationEt.getText().toString();
                String patientWeight=patientWeightEt.getText().toString();
                String patientInfo=patientInfoEt.getText().toString();
                patientItem.setPatientName(patientName);
                try {
                    patientItem.setAge(Integer.parseInt(patientAge));
                }catch (Exception e)
                {
                    Integer i=null;
                    patientItem.setAge(i);
                }
                patientItem.setOccup(occupation);
                try{
                patientItem.setWeight(Integer.parseInt(patientWeight));
                }
                catch (Exception e)
                {
                    Integer i=null;
                    patientItem.setWeight(i);
                }
                patientItem.setInfo(patientInfo);
                if(!patientName.isEmpty() &&patientAge !=null)
                {
                    presenter.addPatientToServer(patientItem);
                    presenter.onPatientCreateSucessfull(context);
                    PatientsListActivity.start(context);

                }else{
                    presenter.onPatientCreateFailure(context);
                }
            }
        });
    }


    @Override
    public void setPatientCreateSucessfull(Context context)
    {
        Toast.makeText(context, "Patient Added Sucessfully", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void setPatientCreateFailure(Context context)
    {
        Toast.makeText(context, "Name or Id or Age is not added , please try again", Toast.LENGTH_SHORT).show();
    }
}
