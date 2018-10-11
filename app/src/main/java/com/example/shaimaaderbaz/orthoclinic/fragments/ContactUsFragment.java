package com.example.shaimaaderbaz.orthoclinic.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.activities.HomeActivity;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactUsFragment extends Fragment {

    public ContactUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ContactUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactUsFragment newInstance() {
        ContactUsFragment fragment = new ContactUsFragment();
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
        View view = inflater.inflate(R.layout.activity_contact_us,container,false);
        ((HomeActivity) getActivity())
                .setActionBarTitle("Contact Us");
        ButterKnife.bind(this,view);
        return view;
    }

}
