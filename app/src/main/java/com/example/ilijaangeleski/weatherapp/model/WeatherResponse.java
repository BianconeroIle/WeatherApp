package com.example.ilijaangeleski.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public class WeatherResponse implements Serializable {

    @SerializedName("dt")
    private long date;
    @SerializedName("name")
    private String cityName;
    private long visibility;
    private CloudsDTO cloudsDTO;
    private CoordsDTO coordsDTO;
    private MainDTO mainDTO;
    private SysDTO sysDTO;
    private List<WeatherDTO> weatherData;

    public WeatherResponse(long date, String cityName, long visibility, CloudsDTO cloudsDTO, CoordsDTO coordsDTO, MainDTO mainDTO, SysDTO sysDTO, List<WeatherDTO> weatherData) {
        this.date = date;
        this.cityName = cityName;
        this.visibility = visibility;
        this.cloudsDTO = cloudsDTO;
        this.coordsDTO = coordsDTO;
        this.mainDTO = mainDTO;
        this.sysDTO = sysDTO;
        this.weatherData = weatherData;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public CloudsDTO getCloudsDTO() {
        return cloudsDTO;
    }

    public void setCloudsDTO(CloudsDTO cloudsDTO) {
        this.cloudsDTO = cloudsDTO;
    }

    public CoordsDTO getCoordsDTO() {
        return coordsDTO;
    }

    public void setCoordsDTO(CoordsDTO coordsDTO) {
        this.coordsDTO = coordsDTO;
    }

    public MainDTO getMainDTO() {
        return mainDTO;
    }

    public void setMainDTO(MainDTO mainDTO) {
        this.mainDTO = mainDTO;
    }

    public SysDTO getSysDTO() {
        return sysDTO;
    }

    public void setSysDTO(SysDTO sysDTO) {
        this.sysDTO = sysDTO;
    }

    public List<WeatherDTO> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(List<WeatherDTO> weatherData) {
        this.weatherData = weatherData;
    }
}
