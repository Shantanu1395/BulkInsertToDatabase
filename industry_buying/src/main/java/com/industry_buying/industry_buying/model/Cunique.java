package com.industry_buying.industry_buying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cunique {
    @Id
    private int id;
    @Column(length=255)
    private String message;
    private String truth;
    private String cube;
    private String google;
    private String google_spam;
    private String google_not_spam;
    private String ibm;
    private double ibm_spam;
    private double ibm_not_spam;

    public Cunique(int id, String message, String truth, String cube, String google, String google_spam, String google_not_spam, String ibm, double ibm_spam, double ibm_not_spam) {
        this.id = id;
        this.message = message;
        this.truth = truth;
        this.cube = cube;
        this.google = google;
        this.google_spam = google_spam;
        this.google_not_spam = google_not_spam;
        this.ibm = ibm;
        this.ibm_spam = ibm_spam;
        this.ibm_not_spam = ibm_not_spam;
    }

    public Cunique(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTruth() {
        return truth;
    }

    public void setTruth(String truth) {
        this.truth = truth;
    }

    public String getCube() {
        return cube;
    }

    public void setCube(String cube) {
        this.cube = cube;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getGoogle_spam() {
        return google_spam;
    }

    public void setGoogle_spam(String google_spam) {
        this.google_spam = google_spam;
    }

    public String getGoogle_not_spam() {
        return google_not_spam;
    }

    public void setGoogle_not_spam(String google_not_spam) {
        this.google_not_spam = google_not_spam;
    }

    public String getIbm() {
        return ibm;
    }

    public void setIbm(String ibm) {
        this.ibm = ibm;
    }

    public double getIbm_spam() {
        return ibm_spam;
    }

    public void setIbm_spam(double ibm_spam) {
        this.ibm_spam = ibm_spam;
    }

    public double getIbm_not_spam() {
        return ibm_not_spam;
    }

    public void setIbm_not_spam(double ibm_not_spam) {
        this.ibm_not_spam = ibm_not_spam;
    }
}
