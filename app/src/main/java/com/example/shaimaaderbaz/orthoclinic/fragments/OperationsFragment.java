package com.example.shaimaaderbaz.orthoclinic.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.AddPatientPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.presenter.OperationsPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.OperationsView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaimaa Derbaz on 7/30/2018.
 */

public class OperationsFragment extends Fragment implements OperationsView{
    OperationsPresenterImp presenter;
    Context context;
    @BindView(R.id.operation_text)
    EditText operation_name_text;
    @BindView(R.id.date_text)
    EditText date_text;
    @BindView(R.id.steps_text)
    EditText steps_text;
    @BindView(R.id.person_text)
    EditText person_text;
    @BindView(R.id.follow_text)
    EditText follow_text;
    @BindView(R.id.select_image_button_op)
    Button select_image;
    @BindView(R.id.select_video_button_op)
    Button select_vedio;
    @BindView(R.id.btnAddOperation)
    Button btnAddOperation;

    private int mPatientId;
    private static final String PATIENT_KEY = "patient_key";

    public static OperationsFragment newInstance(int patientID) {
        OperationsFragment fragment = new OperationsFragment();
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
        View view = inflater.inflate(R.layout.fragment_patient_profile_operations, container, false);
        presenter = new OperationsPresenterImp(this);
        context=getContext();
        ButterKnife.bind(this,view);
        btnAddOperation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                OperationsItem operationsItem = new OperationsItem();
                String name=operation_name_text.getText().toString();
                String date=date_text.getText().toString();
                String steps=steps_text.getText().toString();
                String persons=person_text.getText().toString();
                String followup=follow_text.getText().toString();
                operationsItem.setName(name);
                operationsItem.setDate(date);
                operationsItem.setSteps(steps);
                operationsItem.setPersons(persons);
                operationsItem.setFollowup(followup);

                if(!name.isEmpty() &&!date.isEmpty() &&!persons.isEmpty())
                {
                    presenter.addOperationsToServer(operationsItem);
                    presenter.onOperationsCreateSucessfull(context);

                }else{
                    presenter.onOperationsCreateFailure(context);
                }
            }
        });

        return view;
    }

    @Override
    public void setOperationsCreateSucessfull (Context context)
    {
        Toast.makeText(context, "Operations Added Sucessfully", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void setOperationsCreateFailure (Context context)
    {
        Toast.makeText(context, "Op Name or Date or Persons not Added, please try again", Toast.LENGTH_SHORT).show();
    }
}
