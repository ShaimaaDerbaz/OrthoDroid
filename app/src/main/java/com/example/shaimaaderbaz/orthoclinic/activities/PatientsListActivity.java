package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.adapters.PatientItemsAdapter;
import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.PatientListPresenter;
import com.example.shaimaaderbaz.orthoclinic.presenter.PatientListPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.PatientListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PatientsListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,
        PatientListView,PatientItemsAdapter.PatientsItemsAdapterListener{
    @BindView(R.id.recyclerViewItemPatient)
    RecyclerView patientsRecyclerview;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.searchPatients)
    EditText searchPatients;

    ArrayList<PatientItem> allPatients;
    PatientItemsAdapter patientItemsAdapter;
    PatientListPresenterImp presenter ;

    public static void start(Context context) {
        Intent starter = new Intent(context, PatientsListActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(PatientsListActivity.this,AddPatientActivity.class);
                startActivity(i);
            }
        });

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
                presenter.filterPatientsResult(s.toString(),allPatients);
            }
        });

        //initiateRefresh(flag);
        //insertCustomersTolocalDB(dataSet);


    presenter = new PatientListPresenterImp(this);
        presenter.retreivePatientsFromServer();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.patients_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.new_patient) {
            Intent i =new Intent(PatientsListActivity.this,AddPatientActivity.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent i =new Intent(PatientsListActivity.this,PatientProfileActivity.class);
            startActivity(i);

        } else if (id == R.id.search) {

        } else if (id == R.id.contact_us) {
            ContactUsActivity.start(this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showPatients(List<PatientItem> allPatientData)
    {
        patientsRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        patientItemsAdapter = new PatientItemsAdapter(this,allPatientData);
        patientsRecyclerview.setAdapter(patientItemsAdapter);
    }

    @Override
    public void onItemClicked(int id) {
        PatientProfileActivity.start(this,id);
    }


}
