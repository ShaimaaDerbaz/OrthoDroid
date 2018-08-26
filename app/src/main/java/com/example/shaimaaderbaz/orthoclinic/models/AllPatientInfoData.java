package com.example.shaimaaderbaz.orthoclinic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/26/2018.
 */

public class AllPatientInfoData{
        @SerializedName("patient")
        @Expose
        private PatientItem patient;
        @SerializedName("complains")
        @Expose
        private List<ComplainItem> complains;
        @SerializedName("radiations")
        @Expose
        private List<RadiationItem> radiations;
        @SerializedName("labs")
        @Expose
        private List<LabItem> labs;
        @SerializedName("operations")
        @Expose
        private List<OperationsItem> operations;
        @SerializedName("medical_history")
        @Expose
        private List<MedicalHistoryItem> medical_history;

        public AllPatientInfoData() {
        }

        public PatientItem getPatient() {
                return patient;
        }

        public void setPatient(PatientItem patient) {
                this.patient = patient;
        }

        public List<ComplainItem> getComplains() {
                return complains;
        }

        public void setComplains(List<ComplainItem> complains) {
                this.complains = complains;
        }

        public List<RadiationItem> getRadiations() {
                return radiations;
        }

        public void setRadiations(List<RadiationItem> radiations) {
                this.radiations = radiations;
        }

        public List<LabItem> getLabs() {
                return labs;
        }

        public void setLabs(List<LabItem> labs) {
                this.labs = labs;
        }

        public List<OperationsItem> getOperations() {
                return operations;
        }

        public void setOperations(List<OperationsItem> operations) {
                this.operations = operations;
        }

        public List<MedicalHistoryItem> getMedical_history() {
                return medical_history;
        }

        public void setMedical_history(List<MedicalHistoryItem> medical_history) {
                this.medical_history = medical_history;
        }
}
