package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class InvestigationItem {
    Boolean chemistry,cls,cytology,xray,scanogram,ct,mri,dexa,bonescan;
    Info chemistryInfo,clsInfo,cytologyInfo,xrayInfo,scanogramInfo,ctInfo,mriInfo,dexaInfo,bonescanInfo;

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
        this.chemistryInfo = chemistryInfo;
        this.clsInfo = clsInfo;
        this.cytologyInfo = cytologyInfo;
        this.xrayInfo = xrayInfo;
        this.scanogramInfo = scanogramInfo;
        this.ctInfo = ctInfo;
        this.mriInfo = mriInfo;
        this.dexaInfo = dexaInfo;
        this.bonescanInfo = bonescanInfo;
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

    public Info getChemistryInfo() {
        return chemistryInfo;
    }

    public void setChemistryInfo(Info chemistryInfo) {
        this.chemistryInfo = chemistryInfo;
    }

    public Info getClsInfo() {
        return clsInfo;
    }

    public void setClsInfo(Info clsInfo) {
        this.clsInfo = clsInfo;
    }

    public Info getCytologyInfo() {
        return cytologyInfo;
    }

    public void setCytologyInfo(Info cytologyInfo) {
        this.cytologyInfo = cytologyInfo;
    }

    public Info getXrayInfo() {
        return xrayInfo;
    }

    public void setXrayInfo(Info xrayInfo) {
        this.xrayInfo = xrayInfo;
    }

    public Info getScanogramInfo() {
        return scanogramInfo;
    }

    public void setScanogramInfo(Info scanogramInfo) {
        this.scanogramInfo = scanogramInfo;
    }

    public Info getCtInfo() {
        return ctInfo;
    }

    public void setCtInfo(Info ctInfo) {
        this.ctInfo = ctInfo;
    }

    public Info getMriInfo() {
        return mriInfo;
    }

    public void setMriInfo(Info mriInfo) {
        this.mriInfo = mriInfo;
    }

    public Info getDexaInfo() {
        return dexaInfo;
    }

    public void setDexaInfo(Info dexaInfo) {
        this.dexaInfo = dexaInfo;
    }

    public Info getBonescanInfo() {
        return bonescanInfo;
    }

    public void setBonescanInfo(Info bonescanInfo) {
        this.bonescanInfo = bonescanInfo;
    }
}
