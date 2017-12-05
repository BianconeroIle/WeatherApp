package com.example.ilijaangeleski.weatherapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilijaangeleski.weatherapp.R;
import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;
import com.example.ilijaangeleski.weatherapp.presenter.MainPresenter;
import com.example.ilijaangeleski.weatherapp.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.edt_cityName)
    EditText edt_cityName;


    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
    }




    @Override
    public void setCityError() {
        edt_cityName.setError(getString(R.string.hint_enter_city_name));
    }

    @OnClick(R.id.btn_enter)
    public void onClickEnter(){
        mainPresenter.validateCity(edt_cityName.getText().toString());
        hideKeyboard();

    }
    @Override
    public void validateCityAndSendIntent(WeatherResponse weatherResponse, String city) {
        sendIntent(weatherResponse);
    }

    @Override
    public void errorGettingWeatherData() {
        Toast.makeText(this, "Error getting weather data from server", Toast.LENGTH_LONG).show();
    }

    public void sendIntent(WeatherResponse weatherResponse){
        Intent i = new Intent(MainActivity.this,WeatherDetailsActivity.class);
        i.putExtra("getCityName" , edt_cityName.getText().toString());
        i.putExtra("weatherResponse",weatherResponse);
        startActivity(i);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
