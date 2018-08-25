package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class ExaminationItem {
    Boolean trauma,knee,shoulder,sqine,pelvis,ankefoot,elbow,wrist;
    Info traumaInfo,kneeInfo,shoulderInfo,sqineInfo,pelvisInfo,ankefootInfo,elbowInfo,wristInfo;
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
        this.traumaInfo = traumaInfo;
        this.kneeInfo = kneeInfo;
        this.shoulderInfo = shoulderInfo;
        this.sqineInfo = sqineInfo;
        this.pelvisInfo = pelvisInfo;
        this.ankefootInfo = ankefootInfo;
        this.elbowInfo = elbowInfo;
        this.wristInfo = wristInfo;
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

    public Info getTraumaInfo() {
        return traumaInfo;
    }

    public void setTraumaInfo(Info traumaInfo) {
        this.traumaInfo = traumaInfo;
    }

    public Info getKneeInfo() {
        return kneeInfo;
    }

    public void setKneeInfo(Info kneeInfo) {
        this.kneeInfo = kneeInfo;
    }

    public Info getShoulderInfo() {
        return shoulderInfo;
    }

    public void setShoulderInfo(Info shoulderInfo) {
        this.shoulderInfo = shoulderInfo;
    }

    public Info getSqineInfo() {
        return sqineInfo;
    }

    public void setSqineInfo(Info sqineInfo) {
        this.sqineInfo = sqineInfo;
    }

    public Info getPelvisInfo() {
        return pelvisInfo;
    }

    public void setPelvisInfo(Info pelvisInfo) {
        this.pelvisInfo = pelvisInfo;
    }

    public Info getAnkefootInfo() {
        return ankefootInfo;
    }

    public void setAnkefootInfo(Info ankefootInfo) {
        this.ankefootInfo = ankefootInfo;
    }

    public Info getElbowInfo() {
        return elbowInfo;
    }

    public void setElbowInfo(Info elbowInfo) {
        this.elbowInfo = elbowInfo;
    }

    public Info getWristInfo() {
        return wristInfo;
    }

    public void setWristInfo(Info wristInfo) {
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
