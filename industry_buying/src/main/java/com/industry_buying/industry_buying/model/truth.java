package com.industry_buying.industry_buying.model;

public class truth {

    int truth_spams;
    int truth_not_spams;

    public truth(){

    }

    public truth(int truth_spams, int truth_not_spams) {
        this.truth_spams = truth_spams;
        this.truth_not_spams = truth_not_spams;
    }

    public int getTruth_spams() {
        return truth_spams;
    }

    public void setTruth_spams(int truth_spams) {
        this.truth_spams = truth_spams;
    }

    public int getTruth_not_spams() {
        return truth_not_spams;
    }

    public void setTruth_not_spams(int truth_not_spams) {
        this.truth_not_spams = truth_not_spams;
    }
}
