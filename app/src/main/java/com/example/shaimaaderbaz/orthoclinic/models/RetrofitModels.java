package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RetrofitModels {

    public class AllDataResponse {

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

    public class Complain {
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

    public class Radiation {
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

    public class Lab {
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

    public class MedicalHistory {
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




}
