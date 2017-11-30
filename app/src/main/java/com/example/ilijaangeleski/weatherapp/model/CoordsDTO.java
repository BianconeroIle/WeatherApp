package com.example.ilijaangeleski.weatherapp.model;

import java.io.Serializable;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public class CoordsDTO implements Serializable{

    private double lon;
    private double lat;

    public CoordsDTO(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
