package com.example.ilijaangeleski.weatherapp.model;

import java.io.Serializable;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public class WindDTO implements Serializable{

    private double speed;
    private int deg;

    public WindDTO(double speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
}
