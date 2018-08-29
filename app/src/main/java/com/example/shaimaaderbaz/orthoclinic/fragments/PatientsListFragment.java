package com.example.shaimaaderbaz.orthoclinic.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.activities.PatientProfileActivity;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientItemsAdapter;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.PatientListPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.PatientListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PatientsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientsListFragment extends Fragment implements PatientListView,
        PatientItemsAdapter.PatientsItemsAdapterListener{

    @BindView(R.id.recyclerViewItemPatient)
    RecyclerView patientsRecyclerview;

    @BindView(R.id.searchPatients)
    EditText searchPatients;

    List<PatientItem> allPatients;
    PatientItemsAdapter patientItemsAdapter;
    PatientListPresenterImp presenter ;

    public PatientsListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PatientsListFragment newInstance() {
        PatientsListFragment fragment = new PatientsListFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patients_list,container,false);
        ButterKnife.bind(this,view);

        presenter = new PatientListPresenterImp(this);
        presenter.retreivePatientsFromServer();

        searchPatients.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (allPatients != null)
                    presenter.filterPatientsResult(s.toString(),allPatients);
            }
        });
        return view;
    }

    @Override
    public void showPatients(List<PatientItem> allPatientData)
    {
        allPatients = allPatientData;
        patientsRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
        patientItemsAdapter = new PatientItemsAdapter(this.getContext(),allPatientData,
                this);
        patientsRecyclerview.setAdapter(patientItemsAdapter);
        allPatients=allPatientData;

    }

    @Override
    public void showSearchResult(List<PatientItem> filteredPatients) {
        patientsRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
        patientItemsAdapter = new PatientItemsAdapter(this.getActivity(),filteredPatients, this);
        patientsRecyclerview.setAdapter(patientItemsAdapter);
    }

    @Override
    public void onItemClicked(int id) {
        PatientProfileActivity.start(getContext(),id);
    }
}
