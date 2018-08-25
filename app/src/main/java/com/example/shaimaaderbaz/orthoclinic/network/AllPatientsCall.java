package com.example.shaimaaderbaz.orthoclinic.network;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public interface AllPatientsCall {

    void success(List<PatientItem> patientItems);

    void error(String error);
}
