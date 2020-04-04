package com.industry_buying.industry_buying.model;

public class google {

    int google_spams;
    int google_not_spams;
    double google_avg_spams;
    double google_avg_not_spams;

    public google(int google_spams, int google_not_spams, double google_avg_spams, double google_avg_not_spams) {
        this.google_spams = google_spams;
        this.google_not_spams = google_not_spams;
        this.google_avg_spams = google_avg_spams;
        this.google_avg_not_spams = google_avg_not_spams;
    }

    public google() {
    }

    public int getGoogle_spams() {
        return google_spams;
    }

    public void setGoogle_spams(int google_spams) {
        this.google_spams = google_spams;
    }

    public int getGoogle_not_spams() {
        return google_not_spams;
    }

    public void setGoogle_not_spams(int google_not_spams) {
        this.google_not_spams = google_not_spams;
    }

    public double getGoogle_avg_spams() {
        return google_avg_spams;
    }

    public void setGoogle_avg_spams(double google_avg_spams) {
        this.google_avg_spams = google_avg_spams;
    }

    public double getGoogle_avg_not_spams() {
        return google_avg_not_spams;
    }

    public void setGoogle_avg_not_spams(double google_avg_not_spams) {
        this.google_avg_not_spams = google_avg_not_spams;
    }
}
