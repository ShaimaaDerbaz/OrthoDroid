package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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
        implements NavigationView.OnNavigationItemSelectedListener ,PatientListView{
    @BindView(R.id.recyclerViewItemPatient)
    RecyclerView patientsRecyclerview;

    ArrayList<PatientItem> allPatients;
    PatientItemsAdapter patientItemsAdapter;
    PatientListPresenterImp presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(PatientsListActivity.this,AddPatientActivity.class);
                startActivity(i);
            }
        });
        ButterKnife.bind(this);
        presenter.retreivePatientsFromServer();
        /*allPatients = new ArrayList<>();
        PatientItem patient =new PatientItem() ;
        patient.setPatientName("pateint test");
        patient.setId("00000");
        patient.setAge(18);
        patient.setCreatedDate("7/8/2018");
        patient.setOccup("Test");
        patient.setInfo("Test Info");

        for (int i=0;i<10;i++)
        {
            allPatients.add(patient) ;
        }
        patientsRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        patientItemsAdapter = new PatientItemsAdapter(this,allPatients);
        patientsRecyclerview.setAdapter(patientItemsAdapter);*/

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

        } else if (id == R.id.nav_manage) {

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
}
