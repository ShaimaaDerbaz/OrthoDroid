package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class ExaminationItem {
    Boolean trauma,knee,shoulder,sqine,pelvis,ankefoot,elbow,wrist;
    String traumaInfo,kneeInfo,shoulderInfo,sqineInfo,pelvisInfo,ankefootInfo,elbowInfo,wristInfo;
    String traumaS,kneeS,shoulderS,sqineS,pelvisS,ankefootS,elbowS,wristS;

    public ExaminationItem() {
    }

    public ExaminationItem(Boolean trauma, Boolean knee, Boolean shoulder, Boolean sqine, Boolean pelvis, Boolean ankefoot, Boolean elbow, Boolean wrist, Info traumaInfo, Info kneeInfo, Info shoulderInfo, Info sqineInfo, Info pelvisInfo, Info ankefootInfo, Info elbowInfo, Info wristInfo) {
        this.trauma = trauma;
        this.knee = knee;
        this.shoulder = shoulder;
        this.sqine = sqine;
        this.pelvis = pelvis;
        this.ankefoot = ankefoot;
        this.elbow = elbow;
        this.wrist = wrist;

    }

    public Boolean getTrauma() {
        return trauma;
    }

    public void setTrauma(Boolean trauma) {
        this.trauma = trauma;
    }

    public Boolean getKnee() {
        return knee;
    }

    public void setKnee(Boolean knee) {
        this.knee = knee;
    }

    public Boolean getShoulder() {
        return shoulder;
    }

    public void setShoulder(Boolean shoulder) {
        this.shoulder = shoulder;
    }

    public Boolean getSqine() {
        return sqine;
    }

    public void setSqine(Boolean sqine) {
        this.sqine = sqine;
    }

    public Boolean getPelvis() {
        return pelvis;
    }

    public void setPelvis(Boolean pelvis) {
        this.pelvis = pelvis;
    }

    public Boolean getAnkefoot() {
        return ankefoot;
    }

    public void setAnkefoot(Boolean ankefoot) {
        this.ankefoot = ankefoot;
    }

    public Boolean getElbow() {
        return elbow;
    }

    public void setElbow(Boolean elbow) {
        this.elbow = elbow;
    }

    public Boolean getWrist() {
        return wrist;
    }

    public void setWrist(Boolean wrist) {
        this.wrist = wrist;
    }

    public String getTraumaInfo() {
        return traumaInfo;
    }

    public void setTraumaInfo(String traumaInfo) {
        this.traumaInfo = traumaInfo;
    }

    public String getKneeInfo() {
        return kneeInfo;
    }

    public void setKneeInfo(String kneeInfo) {
        this.kneeInfo = kneeInfo;
    }

    public String getShoulderInfo() {
        return shoulderInfo;
    }

    public void setShoulderInfo(String shoulderInfo) {
        this.shoulderInfo = shoulderInfo;
    }

    public String getSqineInfo() {
        return sqineInfo;
    }

    public void setSqineInfo(String sqineInfo) {
        this.sqineInfo = sqineInfo;
    }

    public String getPelvisInfo() {
        return pelvisInfo;
    }

    public void setPelvisInfo(String pelvisInfo) {
        this.pelvisInfo = pelvisInfo;
    }

    public String getAnkefootInfo() {
        return ankefootInfo;
    }

    public void setAnkefootInfo(String ankefootInfo) {
        this.ankefootInfo = ankefootInfo;
    }

    public String getElbowInfo() {
        return elbowInfo;
    }

    public void setElbowInfo(String elbowInfo) {
        this.elbowInfo = elbowInfo;
    }

    public String getWristInfo() {
        return wristInfo;
    }

    public void setWristInfo(String wristInfo) {
        this.wristInfo = wristInfo;
    }

    public String getTraumaS() {
        return traumaS;
    }

    public void setTraumaS(String traumaS) {
        this.traumaS = traumaS;
    }

    public String getKneeS() {
        return kneeS;
    }

    public void setKneeS(String kneeS) {
        this.kneeS = kneeS;
    }

    public String getShoulderS() {
        return shoulderS;
    }

    public void setShoulderS(String shoulderS) {
        this.shoulderS = shoulderS;
    }

    public String getSqineS() {
        return sqineS;
    }

    public void setSqineS(String sqineS) {
        this.sqineS = sqineS;
    }

    public String getPelvisS() {
        return pelvisS;
    }

    public void setPelvisS(String pelvisS) {
        this.pelvisS = pelvisS;
    }

    public String getAnkefootS() {
        return ankefootS;
    }

    public void setAnkefootS(String ankefootS) {
        this.ankefootS = ankefootS;
    }

    public String getElbowS() {
        return elbowS;
    }

    public void setElbowS(String elbowS) {
        this.elbowS = elbowS;
    }

    public String getWristS() {
        return wristS;
    }

    public void setWristS(String wristS) {
        this.wristS = wristS;
    }
}
