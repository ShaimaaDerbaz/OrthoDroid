package com.example.shaimaaderbaz.orthoclinic.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.AddPatientPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.AddPatientView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddPatientFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPatientFragment extends Fragment implements AddPatientView {

    private AddPatientPresenterImp presenter;

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
    @BindView(R.id.progress)
    ProgressBar mProgressBar;

    AddPatientFragmentListener mAddPatientFragmentListener;

    public AddPatientFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AddPatientFragment newInstance() {
        AddPatientFragment fragment = new AddPatientFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddPatientFragmentListener)
            mAddPatientFragmentListener = (AddPatientFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_patient,container,false);
        ButterKnife.bind(this,view);
        presenter = new AddPatientPresenterImp(this);
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
                    patientItem.setAge(null);
                }
                patientItem.setOccup(occupation);
                try{
                    patientItem.setWeight(Integer.parseInt(patientWeight));
                }
                catch (Exception e)
                {
                    patientItem.setWeight(null);
                }
                patientItem.setInfo(patientInfo);
                if(!patientName.isEmpty() && patientItem.getAge() != null)
                {
                    presenter.addPatientToServer(patientItem);
                    mProgressBar.setVisibility(View.VISIBLE);

                }else{
                    setPatientCreateFailure();
                }
            }
        });
        return view;
    }

    @Override
    public void setPatientCreateSucessfull()
    {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Patient Added Sucessfully", Toast.LENGTH_SHORT).show();
        if(mAddPatientFragmentListener != null)
            mAddPatientFragmentListener.onPatientAdded();
    }
    @Override
    public void setPatientCreateFailure()
    {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Failed to add patient", Toast.LENGTH_SHORT).show();
    }

    public interface AddPatientFragmentListener {
        void onPatientAdded();
    }
}
