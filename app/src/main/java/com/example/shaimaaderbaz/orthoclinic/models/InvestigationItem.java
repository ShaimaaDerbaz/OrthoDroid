package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class InvestigationItem {
    Boolean chemistry,cls,cytology,xray,scanogram,ct,mri,dexa,bonescan;
    String chemistryInfo,clsInfo,cytologyInfo,xrayInfo,scanogramInfo,ctInfo,mriInfo,dexaInfo,bonescanInfo;


    public InvestigationItem() {
    }

    public InvestigationItem(Boolean chemistry, Boolean cls, Boolean cytology, Boolean xray, Boolean scanogram, Boolean ct, Boolean mri, Boolean dexa, Boolean bonescan, Info chemistryInfo, Info clsInfo, Info cytologyInfo, Info xrayInfo, Info scanogramInfo, Info ctInfo, Info mriInfo, Info dexaInfo, Info bonescanInfo) {
        this.chemistry = chemistry;
        this.cls = cls;
        this.cytology = cytology;
        this.xray = xray;
        this.scanogram = scanogram;
        this.ct = ct;
        this.mri = mri;
        this.dexa = dexa;
        this.bonescan = bonescan;

    }

    public Boolean getChemistry() {
        return chemistry;
    }

    public void setChemistry(Boolean chemistry) {
        this.chemistry = chemistry;
    }

    public Boolean getCls() {
        return cls;
    }

    public void setCls(Boolean cls) {
        this.cls = cls;
    }

    public Boolean getCytology() {
        return cytology;
    }

    public void setCytology(Boolean cytology) {
        this.cytology = cytology;
    }

    public Boolean getXray() {
        return xray;
    }

    public void setXray(Boolean xray) {
        this.xray = xray;
    }

    public Boolean getScanogram() {
        return scanogram;
    }

    public void setScanogram(Boolean scanogram) {
        this.scanogram = scanogram;
    }

    public Boolean getCt() {
        return ct;
    }

    public void setCt(Boolean ct) {
        this.ct = ct;
    }

    public Boolean getMri() {
        return mri;
    }

    public void setMri(Boolean mri) {
        this.mri = mri;
    }

    public Boolean getDexa() {
        return dexa;
    }

    public void setDexa(Boolean dexa) {
        this.dexa = dexa;
    }

    public Boolean getBonescan() {
        return bonescan;
    }

    public void setBonescan(Boolean bonescan) {
        this.bonescan = bonescan;
    }

    public String getChemistryInfo() {
        return chemistryInfo;
    }

    public void setChemistryInfo(String chemistryInfo) {
        this.chemistryInfo = chemistryInfo;
    }

    public String getClsInfo() {
        return clsInfo;
    }

    public void setClsInfo(String clsInfo) {
        this.clsInfo = clsInfo;
    }

    public String getCytologyInfo() {
        return cytologyInfo;
    }

    public void setCytologyInfo(String cytologyInfo) {
        this.cytologyInfo = cytologyInfo;
    }

    public String getXrayInfo() {
        return xrayInfo;
    }

    public void setXrayInfo(String xrayInfo) {
        this.xrayInfo = xrayInfo;
    }

    public String getScanogramInfo() {
        return scanogramInfo;
    }

    public void setScanogramInfo(String scanogramInfo) {
        this.scanogramInfo = scanogramInfo;
    }

    public String getCtInfo() {
        return ctInfo;
    }

    public void setCtInfo(String ctInfo) {
        this.ctInfo = ctInfo;
    }

    public String getMriInfo() {
        return mriInfo;
    }

    public void setMriInfo(String mriInfo) {
        this.mriInfo = mriInfo;
    }

    public String getDexaInfo() {
        return dexaInfo;
    }

    public void setDexaInfo(String dexaInfo) {
        this.dexaInfo = dexaInfo;
    }

    public String getBonescanInfo() {
        return bonescanInfo;
    }

    public void setBonescanInfo(String bonescanInfo) {
        this.bonescanInfo = bonescanInfo;
    }
}
