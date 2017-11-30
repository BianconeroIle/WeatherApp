package com.example.ilijaangeleski.weatherapp.model;

import java.io.Serializable;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public class CoordsDTO implements Serializable{

    private long lon;
    private long lat;

    public CoordsDTO(long lon, long lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }
}
