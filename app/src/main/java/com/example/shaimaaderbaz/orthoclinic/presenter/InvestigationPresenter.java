package com.example.shaimaaderbaz.orthoclinic.presenter;

import com.example.shaimaaderbaz.orthoclinic.models.InvestigationItem;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;

/**
 * Created by Shaimaa Derbaz on 8/5/2018.
 */

public interface InvestigationPresenter {

    void addInvestigationToServer(InvestigationItem investigationItem, int patientId);
}


