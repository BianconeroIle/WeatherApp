package com.example.ilijaangeleski.weatherapp.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilijaangeleski.weatherapp.R;
import com.example.ilijaangeleski.weatherapp.model.WeatherDTO;
import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;
import com.example.ilijaangeleski.weatherapp.presenter.MainPresenter;
import com.example.ilijaangeleski.weatherapp.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.edt_cityName)
    EditText edt_cityName;
    @BindView(R.id.cityName)
    TextView cityName;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.condition)
    TextView condition;

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);

    }

    public void initData(WeatherResponse weatherResponse){
        if(weatherResponse != null) {
            cityName.setText(weatherResponse.getCityName());
            temp.setText(weatherResponse.getMainDTO().getTemp() + " \u2103");
            WeatherDTO weather = weatherResponse.getWeatherData().get(0);
            condition.setText(weather.getDescription());
            icon.setImageResource(getResources().getIdentifier(
                    "a_" + weather.getIcon(), "drawable", getPackageName()));
        }
    }
    @Override
    public void showWeatherData(WeatherResponse weatherResponse, String city) {
        initData(weatherResponse);
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
    public void errorGettingWeatherData() {
        Toast.makeText(this, "Error getting weather data from server", Toast.LENGTH_LONG).show();
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
