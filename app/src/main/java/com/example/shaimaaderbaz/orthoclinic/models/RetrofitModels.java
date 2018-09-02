package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RetrofitModels {

    public static class AllDataResponse {

        @SerializedName("complains")
        private ArrayList<Complain> mComplains;

        @SerializedName("radiations")
        private ArrayList<Radiation> mRadiations;

        @SerializedName("labs")
        private ArrayList<Lab> mLabs;

        @SerializedName("medical_history")
        private ArrayList<MedicalHistory> mMedicalHistory;

        public ArrayList<Complain> getmComplains() {
            return mComplains;
        }

        public ArrayList<Radiation> getmRadiations() {
            return mRadiations;
        }

        public ArrayList<Lab> getmLabs() {
            return mLabs;
        }

        public ArrayList<MedicalHistory> getmMedicalHistory() {
            return mMedicalHistory;
        }
    }

    public static class AddDataBaseRequest {
        @SerializedName("patient_id")
        protected int patientId;

        public int getPatientId() {
            return patientId;
        }
    }

    public static class AddOperationRequest extends AddDataBaseRequest {
        @SerializedName("operations")
        private List<Operation> mOperations;

        public AddOperationRequest(List<Operation> mOperations, int patientId) {
            this.patientId = patientId;
            this.mOperations = mOperations;
        }

        public List<Operation> getOperations() {
            return mOperations;
        }
    }

    public static class UpdateOperationRequest extends AddDataBaseRequest {
        private Operation mOperations;

        public UpdateOperationRequest(Operation mOperations, int patientId) {
            this.patientId = patientId;
            this.mOperations = mOperations;
        }

        public Operation getOperations() {
            return mOperations;
        }
    }

    public static class AddMedicalHistoryRequest extends AddDataBaseRequest {
        @SerializedName("medical_history")
        private List<MedicalHistory> mMedicalHistory;

        public AddMedicalHistoryRequest(List<MedicalHistory> mMedicalHistory,int patientId) {
            this.mMedicalHistory = mMedicalHistory;
            this.patientId = patientId;
        }

        public List<MedicalHistory> getMedicalHistory() {
            return mMedicalHistory;
        }
    }

    public static class AddComplainRequest extends AddDataBaseRequest {
        @SerializedName("complains")
        private List<Complain> mComplain;

        public AddComplainRequest(List<Complain> mComplain,int patientId) {
            this.mComplain = mComplain;
            this.patientId = patientId;
        }

        public List<Complain> getmComplain() {
            return mComplain;
        }
    }

    public static class AddRadiationRequest extends AddDataBaseRequest {
        @SerializedName("radiations")
        private List<Radiation> mRadiation;

        public AddRadiationRequest(List<Radiation> mRadiation,int patientId) {
            this.mRadiation = mRadiation;
            this.patientId = patientId;
        }

        public List<Radiation> getmRadiation() {
            return mRadiation;
        }
    }

    public static class AddLabRequest extends AddDataBaseRequest {
        @SerializedName("labs")
        private List<Lab> mLab;

        public AddLabRequest(List<Lab> mLab,int patientId) {
            this.mLab = mLab;
            this.patientId = patientId;
        }

        public List<Lab> getmLab() {
            return mLab;
        }
    }


    public static class Complain {
        @SerializedName("id")
        private int mId;

        @SerializedName("name")
        private String mName;

        @SerializedName("info")
        private String mAdditionalInfo;

        public Complain( String mAdditionalInfo) {
            this.mAdditionalInfo = mAdditionalInfo;
        }
        public Complain(int mId, String mAdditionalInfo) {
            this.mId = mId;
            this.mAdditionalInfo = mAdditionalInfo;
        }

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }
        public String getAdditionalInfo() {
            return mAdditionalInfo;
        }
    }

    public static class Radiation {
        @SerializedName("id")
        private int mId;

        @SerializedName("name")
        private String mName;

        @SerializedName("info")
        private String mAdditionalInfo;

        @SerializedName("radiation_id")
        @Expose
        private Integer radiation_id;

        @SerializedName("examination_date")
        @Expose
        private String examination_date;

        public Radiation ( String mAdditionalInfo) {
            this.mAdditionalInfo = mAdditionalInfo;
        }

        public Radiation (int mId, String mAdditionalInfo) {
            this.mId = mId;
            this.mAdditionalInfo = mAdditionalInfo;
        }

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }

        public String getmAdditionalInfo() {
            return mAdditionalInfo;
        }

        public Integer getRadiation_id() {
            return radiation_id;
        }

        public String getExamination_date() {
            return examination_date;
        }
    }

    public static class Lab {
        @SerializedName("id")
        private int mId;

        @SerializedName("name")
        private String mName;

        @SerializedName("info")
        private String mAdditionalInfo;

        public Lab(String mAdditionalInfo) {
            this.mAdditionalInfo = mAdditionalInfo;
        }

        public Lab (int mId, String mAdditionalInfo) {
            this.mId = mId;
            this.mAdditionalInfo = mAdditionalInfo;

        }

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }

        public String getmAdditionalInfo() {
            return mAdditionalInfo;
        }
    }

    public static class MedicalHistory {
        @SerializedName("id")
        private int mId;

        @SerializedName("state_name")
        private String mName;

        @SerializedName("info")
        private String mAdditionalInfo;

        public MedicalHistory(int mId, String mAdditionalInfo) {
            this.mId = mId;
            this.mAdditionalInfo = mAdditionalInfo;
        }

        public MedicalHistory(String mAdditionalInfo) {
            this.mAdditionalInfo = mAdditionalInfo;
        }

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }

        public String getAdditionalInfo() {
            return mAdditionalInfo;
        }
    }

    public static class Operation {

        @SerializedName("name")
        private String mName;

        @SerializedName("steps")
        private String mSteps;

        @SerializedName("date")
        private String mDate;

        @SerializedName("persons")
        private String mPersons;

        @SerializedName("follow_up")
        private String mFollowUp;


        public Operation(String name, String steps, String date, String persons, String followUp) {
            this.mName = name;
            this.mSteps = steps;
            this.mDate = date;
            this.mPersons = persons;
            this.mFollowUp = followUp;
        }

        public String getName() {
            return mName;
        }

        public String getDate() {
            return mDate;
        }

        public String getPersons() {
            return mPersons;
        }

        public String getFollowUp() {
            return mFollowUp;
        }

        public String getSteps() {
            return mSteps;
        }


    }



}
