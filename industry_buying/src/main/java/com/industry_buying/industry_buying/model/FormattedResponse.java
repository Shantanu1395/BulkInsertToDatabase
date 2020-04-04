package com.industry_buying.industry_buying.model;

public class FormattedResponse {

    int total_matches;
    truth truth;
    cube cube;
    google google;
    ibm ibm;

    public FormattedResponse(int total_matches, com.industry_buying.industry_buying.model.truth truth, com.industry_buying.industry_buying.model.cube cube, com.industry_buying.industry_buying.model.google google, com.industry_buying.industry_buying.model.ibm ibm) {
        this.total_matches = total_matches;
        this.truth = truth;
        this.cube = cube;
        this.google = google;
        this.ibm = ibm;
    }

    public int getTotal_matches() {
        return total_matches;
    }

    public void setTotal_matches(int total_matches) {
        this.total_matches = total_matches;
    }

    public com.industry_buying.industry_buying.model.truth getTruth() {
        return truth;
    }

    public void setTruth(com.industry_buying.industry_buying.model.truth truth) {
        this.truth = truth;
    }

    public com.industry_buying.industry_buying.model.cube getCube() {
        return cube;
    }

    public void setCube(com.industry_buying.industry_buying.model.cube cube) {
        this.cube = cube;
    }

    public com.industry_buying.industry_buying.model.google getGoogle() {
        return google;
    }

    public void setGoogle(com.industry_buying.industry_buying.model.google google) {
        this.google = google;
    }

    public com.industry_buying.industry_buying.model.ibm getIbm() {
        return ibm;
    }

    public void setIbm(com.industry_buying.industry_buying.model.ibm ibm) {
        this.ibm = ibm;
    }
}
