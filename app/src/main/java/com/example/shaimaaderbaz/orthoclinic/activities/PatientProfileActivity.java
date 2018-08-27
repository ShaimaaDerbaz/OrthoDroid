package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.fragments.ExaminationFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.HistoryFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.InvestigationFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.OperationsFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.PersonalFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.SectionsPageAdapter;

public class PatientProfileActivity extends AppCompatActivity {

    private static final String PATIENT_ID_KEY = "patient_id";
    private SectionsPageAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private int mPatientId;

    public static void start(Context context, int patientId) {
        Intent starter = new Intent(context, PatientProfileActivity.class);
        starter.putExtra(PATIENT_ID_KEY,patientId);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        if (getIntent().getIntExtra(PATIENT_ID_KEY,0) !=0 ) {
            mPatientId = getIntent().getIntExtra(PATIENT_ID_KEY,0);
        }
        else {
            throw new RuntimeException("INVALID PATIENT ID");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter =new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.container);
        setUpViewPager(mViewPager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_patient_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpViewPager (ViewPager viewPager)
    {
        SectionsPageAdapter adapter =new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(PersonalFragment.newInstance(mPatientId),
                "Personal Details");
        adapter.addFragment(HistoryFragment.newInstance(mPatientId),
                "History");
        adapter.addFragment(ExaminationFragment.newInstance(mPatientId),
                "Complain & Examination");
        adapter.addFragment(InvestigationFragment.newInstance(mPatientId),
                "Investigation");
        adapter.addFragment(OperationsFragment.newInstance(mPatientId),
                "Operations");
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
    }



}
