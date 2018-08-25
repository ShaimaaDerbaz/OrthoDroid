package com.example.shaimaaderbaz.orthoclinic.repository;


import java.util.HashMap;

public interface SharedPreferencesRepository {
    int getSpecificHistoryId(String historyName);
    int getSpecificComplain(String complainName);
    int getSpecificRadiation(String radiationName);
    int getSpecificLab(String labName);

    HashMap<String,Integer> getAllHistory();
    HashMap<String,Integer> getAllComplains();
    HashMap<String,Integer> getAllRadiations();
    HashMap<String,Integer> getAllLabs();

    void saveHistory(HashMap<String,Integer> records);
    void saveComplains(HashMap<String,Integer> records);
    void saveRadiations(HashMap<String,Integer> records);
    void saveLabs(HashMap<String,Integer> records);

    void clearRepos();
}
