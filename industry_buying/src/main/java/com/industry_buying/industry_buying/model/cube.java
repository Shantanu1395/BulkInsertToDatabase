package com.industry_buying.industry_buying.model;

public class cube {

    int cube_spams;
    int cube_not_spams;

    public cube(int cube_spams, int cube_not_spams) {
        this.cube_spams = cube_spams;
        this.cube_not_spams = cube_not_spams;
    }

    public cube() {
    }

    public int getCube_spams() {
        return cube_spams;
    }

    public void setCube_spams(int cube_spams) {
        this.cube_spams = cube_spams;
    }

    public int getCube_not_spams() {
        return cube_not_spams;
    }

    public void setCube_not_spams(int cube_not_spams) {
        this.cube_not_spams = cube_not_spams;
    }
}
