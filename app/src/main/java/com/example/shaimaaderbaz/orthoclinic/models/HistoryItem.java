package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class HistoryItem {
    Boolean ch,gastritis,smoking,pregnecy,lactation;
    String chInfo,gastritisInfo,smokingInfo,pregnecyInfo,lactationInfo;

    public HistoryItem() {
    }

    public HistoryItem(Boolean ch, Boolean gastritis, Boolean smoking, Boolean pregnecy, Boolean lactation, String chInfo, String gastritisInfo, String smokingInfo, String pregnecyInfo, String lactationInfo) {
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

    public Boolean isCh() {
        return ch;
    }

    public void setCh(Boolean ch) {
        this.ch = ch;
    }

    public Boolean isGastritis() {
        return gastritis;
    }

    public void setGastritis(Boolean gastritis) {
        this.gastritis = gastritis;
    }

    public Boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    public Boolean isPregnecy() {
        return pregnecy;
    }

    public void setPregnecy(Boolean pregnecy) {
        this.pregnecy = pregnecy;
    }

    public Boolean isLactation() {
        return lactation;
    }

    public void setLactation(Boolean lactation) {
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
