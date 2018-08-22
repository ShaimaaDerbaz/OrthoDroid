package com.example.shaimaaderbaz.orthoclinic.fragments;

/**
 * Created by Shaimaa Derbaz on 7/29/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaimaaderbaz.orthoclinic.R;

/**
 * A placeholder fragment containing a simple view.
 */
public  class PersonalFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "personal_tab_fragment";

    public PersonalFragment() {
    }


    public static PersonalFragment newInstance(int sectionNumber) {
        PersonalFragment fragment = new PersonalFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_profile_personal, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text_personal);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        textView.setText("Text personal");
        return view;
    }
}
