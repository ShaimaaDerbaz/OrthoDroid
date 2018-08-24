package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class HistoryItemModel {
    String ch,gastritis,smoking,pregnecy,lactation;
    String chInfo,gastritisInfo,smokingInfo,pregnecyInfo,lactationInfo;

    public HistoryItemModel() {
    }

    public HistoryItemModel(String ch, String gastritis, String smoking, String pregnecy, String lactation, String chInfo, String gastritisInfo, String smokingInfo, String pregnecyInfo, String lactationInfo) {
        this.ch = ch;
        this.gastritis = gastritis;
        this.smoking = smoking;
        this.pregnecy = pregnecy;
        this.lactation = lactation;
        this.chInfo = chInfo;
        this.gastritisInfo = gastritisInfo;
        this.smokingInfo = smokingInfo;
        this.pregnecyInfo = pregnecyInfo;
        this.lactationInfo = lactationInfo;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getGastritis() {
        return gastritis;
    }

    public void setGastritis(String gastritis) {
        this.gastritis = gastritis;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getPregnecy() {
        return pregnecy;
    }

    public void setPregnecy(String pregnecy) {
        this.pregnecy = pregnecy;
    }

    public String getLactation() {
        return lactation;
    }

    public void setLactation(String lactation) {
        this.lactation = lactation;
    }

    public String getChInfo() {
        return chInfo;
    }

    public void setChInfo(String chInfo) {
        this.chInfo = chInfo;
    }

    public String getGastritisInfo() {
        return gastritisInfo;
    }

    public void setGastritisInfo(String gastritisInfo) {
        this.gastritisInfo = gastritisInfo;
    }

    public String getSmokingInfo() {
        return smokingInfo;
    }

    public void setSmokingInfo(String smokingInfo) {
        this.smokingInfo = smokingInfo;
    }

    public String getPregnecyInfo() {
        return pregnecyInfo;
    }

    public void setPregnecyInfo(String pregnecyInfo) {
        this.pregnecyInfo = pregnecyInfo;
    }

    public String getLactationInfo() {
        return lactationInfo;
    }

    public void setLactationInfo(String lactationInfo) {
        this.lactationInfo = lactationInfo;
    }
}
