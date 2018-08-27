package com.example.shaimaaderbaz.orthoclinic.views;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public interface PatientListView {
    void showPatients(List<PatientItem> AllPatients);
    void showSearchResult(List<PatientItem> filteredPatients);
}
