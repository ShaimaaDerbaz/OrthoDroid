package com.example.shaimaaderbaz.orthoclinic.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaimaa Derbaz on 7/29/2018.
 */

  public class SectionsPageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList =new ArrayList<>();
    private final List<String> mFragmentTitleList =new ArrayList<>();
    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment ,String title)
    {
        mFragmentTitleList.add(title);
        mFragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    }


