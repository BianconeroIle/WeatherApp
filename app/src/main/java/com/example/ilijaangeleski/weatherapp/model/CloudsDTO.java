package com.example.ilijaangeleski.weatherapp.model;

import java.io.Serializable;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public class CloudsDTO implements Serializable{

    private int all;

    public CloudsDTO(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
