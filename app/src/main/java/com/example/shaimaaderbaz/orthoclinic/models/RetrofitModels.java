package com.example.shaimaaderbaz.orthoclinic.models;

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



    public static class Complain {
        @SerializedName("id")
        private int mId;

        @SerializedName("name")
        private String mName;

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }
    }

    public static class Radiation {
        @SerializedName("id")
        private int mId;

        @SerializedName("name")
        private String mName;

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }
    }

    public static class Lab {
        @SerializedName("id")
        private int mId;

        @SerializedName("name")
        private String mName;

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
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



}
