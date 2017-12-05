package com.example.ilijaangeleski.weatherapp.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilijaangeleski.weatherapp.R;
import com.example.ilijaangeleski.weatherapp.model.WeatherDTO;
import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;
import com.example.ilijaangeleski.weatherapp.view.DetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 12/5/2017.
 */

public class WeatherDetailsActivity extends AppCompatActivity implements DetailsView {
    @BindView(R.id.cityName)
    TextView cityName;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.condition)
    TextView condition;
    String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_weather_details);
        ButterKnife.bind(this);

    }

    public void initData(WeatherResponse weatherResponse) {
        if (weatherResponse != null && getIntent().getExtras() != null && getIntent().hasExtra("getCityName")
                && getIntent().getExtras() != null && getIntent().hasExtra("weatherResponse")) {
            name = getIntent().getExtras().getString("getCityName");
            weatherResponse = (WeatherResponse) getIntent().getExtras().getSerializable("weatherResponse");
            cityName.setText(weatherResponse.getCityName());
            temp.setText(weatherResponse.getMainDTO().getTemp() + " \u2103");
            WeatherDTO weather = weatherResponse.getWeatherData().get(0);
            condition.setText(weather.getDescription());
            icon.setImageResource(getResources().getIdentifier(
                    "a_" + weather.getIcon(), "drawable", getPackageName()));
        }else {
            errorGettingDetailsFromServer();
        }

    }

    @Override
    public void showWeatherDetails(WeatherResponse weatherResponse) {
        initData(weatherResponse);
    }

    @Override
    public void errorGettingDetailsFromServer() {
        Toast.makeText(this,R.string.error_getting_data_from_server,Toast.LENGTH_LONG).show();
    }
}
