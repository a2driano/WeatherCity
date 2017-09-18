package com.a2driano.city.my.weather.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.city.my.weather.domain.application.App;
import com.a2driano.city.my.weather.domain.interactors.IteractorCurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by a2driano on 18.09.2017.
 */

public class PresenterSearch implements IteractorCurrentWeather {
    private Context mContext;
    private String mCityName;
    private String mUnits;

    public PresenterSearch(Context context) {
        mContext = context;
    }

    public void searchCityWeather(String cityName, String units, View view) {
        mCityName = cityName;
        mUnits = units;
//        WeatherDAO weather = new WeatherProvider(cityId, units).getCurrentWeather();
        WeatherDTO weather = getCurrentWeatherFromServer();
//        Log.d("PresenterSearch", "******************* weather.toString(): " + weather.toString());
//        new AsyncSearch().execute();
    }


    @Override
    public WeatherDTO getCurrentWeatherFromServer() {
        final WeatherDTO[] weatherDTO = {new WeatherDTO()};
        App.getWeatherAPI().getResponse(mCityName, App.WEATHER_API, mUnits).enqueue(new Callback<WeatherDTO>() {
            @Override
            public void onResponse(Call<WeatherDTO> call, Response<WeatherDTO> response) {
                if (response.isSuccessful() & response.body() != null) {
                    weatherDTO[0] = response.body();
                    Log.d("Download", "******************* weatherDTO[0] = response.body().get(0): " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<WeatherDTO> call, Throwable t) {
                Log.d("Download", "******************* onFailure");
            }
        });
        return weatherDTO[0];
    }
}
