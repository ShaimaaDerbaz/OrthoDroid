package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.fragments.ExaminationFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.HistoryFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.InvestigationFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.OperationsFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.PersonalFragment;
import com.example.shaimaaderbaz.orthoclinic.fragments.SectionsPageAdapter;

public class PatientProfileActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    private static final String PATIENT_ID_KEY = "patient_id";
    private SectionsPageAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private int mPatientId;

    public static void start(Context context, int patientId) {
        Intent starter = new Intent(context, PatientProfileActivity.class);
        starter.putExtra(PATIENT_ID_KEY,patientId);
        context.startActivity(starter);
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
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

        mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.container);
        setUpViewPager(mViewPager);
        final TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);
        setTabBG(R.drawable.tab_select,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect);

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
         {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tabLayout.getSelectedTabPosition()==0) {
                    setTabBG(R.drawable.tab_select,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect);
                }
                else if(tabLayout.getSelectedTabPosition()==1) {
                    setTabBG(R.drawable.tab_unselect,R.drawable.tab_select,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect);
                }
                else if(tabLayout.getSelectedTabPosition()==2) {
                    setTabBG(R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_select,R.drawable.tab_unselect,R.drawable.tab_unselect);
                }
                else if(tabLayout.getSelectedTabPosition()==3) {
                    setTabBG(R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_select,R.drawable.tab_unselect);
                }
                else if(tabLayout.getSelectedTabPosition()==4) {
                    setTabBG(R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_select);
                }
                else
                {
                    setTabBG(R.drawable.tab_select,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect,R.drawable.tab_unselect);

                }
            }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {
                 try {

                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });
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
        viewPager.setOffscreenPageLimit(0);
        viewPager.setAdapter(adapter);
    }


    private void setTabBG(int tab1, int tab2, int tab3, int tab4, int tab5){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
            ViewGroup tabStrip = (ViewGroup) tabLayout.getChildAt(0);
            View tabView1 = tabStrip.getChildAt(0);
            View tabView2 = tabStrip.getChildAt(1);
            View tabView3 = tabStrip.getChildAt(2);
            View tabView4 = tabStrip.getChildAt(3);
            View tabView5 = tabStrip.getChildAt(4);

            if (tabView1 != null) {
                int paddingStart = tabView1.getPaddingStart();
                int paddingTop = tabView1.getPaddingTop();
                int paddingEnd = tabView1.getPaddingEnd();
                int paddingBottom = tabView1.getPaddingBottom();
                ViewCompat.setBackground(tabView1, AppCompatResources.getDrawable(tabView1.getContext(), tab1));
                ViewCompat.setPaddingRelative(tabView1, paddingStart, paddingTop, paddingEnd, paddingBottom);
            }

            if (tabView2 != null) {
                int paddingStart = tabView2.getPaddingStart();
                int paddingTop = tabView2.getPaddingTop();
                int paddingEnd = tabView2.getPaddingEnd();
                int paddingBottom = tabView2.getPaddingBottom();
                ViewCompat.setBackground(tabView2, AppCompatResources.getDrawable(tabView2.getContext(), tab2));
                ViewCompat.setPaddingRelative(tabView2, paddingStart, paddingTop, paddingEnd, paddingBottom);
            }
            if (tabView3 != null) {
                int paddingStart = tabView3.getPaddingStart();
                int paddingTop = tabView3.getPaddingTop();
                int paddingEnd = tabView3.getPaddingEnd();
                int paddingBottom = tabView3.getPaddingBottom();
                ViewCompat.setBackground(tabView3, AppCompatResources.getDrawable(tabView3.getContext(), tab3));
                ViewCompat.setPaddingRelative(tabView3, paddingStart, paddingTop, paddingEnd, paddingBottom);
            }
            if (tabView4 != null) {
                int paddingStart = tabView4.getPaddingStart();
                int paddingTop = tabView4.getPaddingTop();
                int paddingEnd = tabView4.getPaddingEnd();
                int paddingBottom = tabView4.getPaddingBottom();
                ViewCompat.setBackground(tabView4, AppCompatResources.getDrawable(tabView4.getContext(), tab4));
                ViewCompat.setPaddingRelative(tabView4, paddingStart, paddingTop, paddingEnd, paddingBottom);
            }
            if (tabView5 != null) {
                int paddingStart = tabView5.getPaddingStart();
                int paddingTop = tabView5.getPaddingTop();
                int paddingEnd = tabView5.getPaddingEnd();
                int paddingBottom = tabView5.getPaddingBottom();
                ViewCompat.setBackground(tabView5, AppCompatResources.getDrawable(tabView5.getContext(), tab5));
                ViewCompat.setPaddingRelative(tabView5, paddingStart, paddingTop, paddingEnd, paddingBottom);
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {
       // Log.i("selected tab ", tabId);

    }



}
