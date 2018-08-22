package com.example.shaimaaderbaz.orthoclinic.models;

import android.graphics.Path;

/**
 * Created by Shaimaa Derbaz on 8/18/2018.
 */

public class PatientProfile {
    HistoryItem historyItem;
    ExaminationItem examinationItem;
    InvestigationItem investigationItem;
    OperationsItem operationsItem;

    public PatientProfile() {
    }

    public PatientProfile(HistoryItem historyItem, ExaminationItem examinationItem, InvestigationItem investigationItem, OperationsItem operationsItem) {
        this.historyItem = historyItem;
        this.examinationItem = examinationItem;
        this.investigationItem = investigationItem;
        this.operationsItem = operationsItem;
    }

    public HistoryItem getHistoryItem() {
        return historyItem;
    }

    public void setHistoryItem(HistoryItem historyItem) {
        this.historyItem = historyItem;
    }

    public ExaminationItem getExaminationItem() {
        return examinationItem;
    }

    public void setExaminationItem(ExaminationItem examinationItem) {
        this.examinationItem = examinationItem;
    }

    public InvestigationItem getInvestigationItem() {
        return investigationItem;
    }

    public void setInvestigationItem(InvestigationItem investigationItem) {
        this.investigationItem = investigationItem;
    }

    public OperationsItem getOperationsItem() {
        return operationsItem;
    }

    public void setOperationsItem(OperationsItem operationsItem) {
        this.operationsItem = operationsItem;
    }
}
