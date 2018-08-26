package com.example.shaimaaderbaz.orthoclinic.network;

import com.example.shaimaaderbaz.orthoclinic.models.AllPatientInfoData;
import com.example.shaimaaderbaz.orthoclinic.models.PatientItem;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public interface AllPatientsInfoCall {

    void success(AllPatientInfoData allPatientInfoData,int patient_id);

    void error(String error);
}
