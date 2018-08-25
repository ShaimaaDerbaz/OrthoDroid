package com.example.shaimaaderbaz.orthoclinic.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SharedPrefsRepositoryImpl implements SharedPreferencesRepository {
    private final SharedPreferences mHistoryPrefs;
    private final SharedPreferences mComplainsPrefs;
    private final SharedPreferences mRadiationPrefs;
    private final SharedPreferences mLabPrefs;

    public SharedPrefsRepositoryImpl(Context context) {
        mHistoryPrefs = context.getApplicationContext().getSharedPreferences("HISTORY_PREFS",
                Context.MODE_PRIVATE);
        mComplainsPrefs = context.getApplicationContext().getSharedPreferences("COMPLAIN_PREFS",
                Context.MODE_PRIVATE);
        mRadiationPrefs = context.getApplicationContext().getSharedPreferences("RADIATION_PREFS",
                Context.MODE_PRIVATE);
        mLabPrefs = context.getApplicationContext().getSharedPreferences("LAB_PREFS",
                Context.MODE_PRIVATE);
    }


    @Override
    public int getSpecificHistoryId(String historyName) {
        return mHistoryPrefs.getInt(historyName,0);
    }

    @Override
    public int getSpecificComplain(String complainName) {
        return mComplainsPrefs.getInt(complainName,0);
    }

    @Override
    public int getSpecificRadiation(String radiationName) {
        return mRadiationPrefs.getInt(radiationName,0);
    }

    @Override
    public int getSpecificLab(String labName) {
        return mLabPrefs.getInt(labName,0);
    }

    @Override
    public HashMap<String, Integer> getAllHistory() {
        return (HashMap<String, Integer>) mHistoryPrefs.getAll();
    }

    @Override
    public HashMap<String, Integer> getAllComplains() {
        return (HashMap<String, Integer>) mComplainsPrefs.getAll();
    }

    @Override
    public HashMap<String, Integer> getAllRadiations() {
        return (HashMap<String, Integer>) mRadiationPrefs.getAll();
    }

    @Override
    public HashMap<String, Integer> getAllLabs() {
        return (HashMap<String, Integer>) mLabPrefs.getAll();
    }

    @Override
    public void saveHistory(HashMap<String, Integer> records) {
        Set<Map.Entry<String, Integer>> recordsSet = records.entrySet();
        SharedPreferences.Editor changes = mHistoryPrefs.edit();
        for (Map.Entry<String, Integer> stringIntegerEntry : recordsSet) {
            if (!TextUtils.isEmpty(stringIntegerEntry.getKey()))
                changes = changes.putInt(stringIntegerEntry.getKey()
                        ,stringIntegerEntry.getValue());
        }
        changes.apply();
    }

    @Override
    public void saveComplains(HashMap<String, Integer> records) {
        Set<Map.Entry<String, Integer>> recordsSet = records.entrySet();
        SharedPreferences.Editor changes = mComplainsPrefs.edit();
        for (Map.Entry<String, Integer> stringIntegerEntry : recordsSet) {
            if (!TextUtils.isEmpty(stringIntegerEntry.getKey()))
                changes = changes.putInt(stringIntegerEntry.getKey()
                        ,stringIntegerEntry.getValue());
        }
        changes.apply();
    }

    @Override
    public void saveRadiations(HashMap<String, Integer> records) {
        Set<Map.Entry<String, Integer>> recordsSet = records.entrySet();
        SharedPreferences.Editor changes = mRadiationPrefs.edit();
        for (Map.Entry<String, Integer> stringIntegerEntry : recordsSet) {
            if (!TextUtils.isEmpty(stringIntegerEntry.getKey()))
                changes = changes.putInt(stringIntegerEntry.getKey()
                        ,stringIntegerEntry.getValue());
        }
        changes.apply();
    }

    @Override
    public void saveLabs(HashMap<String, Integer> records) {
        Set<Map.Entry<String, Integer>> recordsSet = records.entrySet();
        SharedPreferences.Editor changes = mLabPrefs.edit();
        for (Map.Entry<String, Integer> stringIntegerEntry : recordsSet) {
            if (!TextUtils.isEmpty(stringIntegerEntry.getKey()))
                changes = changes.putInt(stringIntegerEntry.getKey()
                        ,stringIntegerEntry.getValue());
        }
        changes.apply();
    }

    @Override
    public void clearRepos() {
        mHistoryPrefs.edit().clear().apply();
        mLabPrefs.edit().clear().apply();
        mRadiationPrefs.edit().clear().apply();
        mComplainsPrefs.edit().clear().apply();
    }
}
