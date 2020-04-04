package com.industry_buying.industry_buying.model;

public class ibm {

    int ibm_spams;
    int ibm_not_spams;
    double ibm_avg_spams;
    double ibm_avg_not_spams;

    public ibm() {
    }

    public int getIbm_spams() {
        return ibm_spams;
    }

    public void setIbm_spams(int ibm_spams) {
        this.ibm_spams = ibm_spams;
    }

    public int getIbm_not_spams() {
        return ibm_not_spams;
    }

    public void setIbm_not_spams(int ibm_not_spams) {
        this.ibm_not_spams = ibm_not_spams;
    }

    public double getIbm_avg_spams() {
        return ibm_avg_spams;
    }

    public void setIbm_avg_spams(double ibm_avg_spams) {
        this.ibm_avg_spams = ibm_avg_spams;
    }

    public double getIbm_avg_not_spams() {
        return ibm_avg_not_spams;
    }

    public void setIbm_avg_not_spams(double ibm_avg_not_spams) {
        this.ibm_avg_not_spams = ibm_avg_not_spams;
    }

    public ibm(int ibm_spams, int ibm_not_spams, double ibm_avg_spams, double ibm_avg_not_spams) {
        this.ibm_spams = ibm_spams;
        this.ibm_not_spams = ibm_not_spams;
        this.ibm_avg_spams = ibm_avg_spams;
        this.ibm_avg_not_spams = ibm_avg_not_spams;
    }
}
