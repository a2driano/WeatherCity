package com.a2driano.sity.my.weather.domain;

import android.util.Log;

import com.a2driano.sity.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.sity.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.sity.my.weather.domain.boundaries.BoundaryCurrentWeather;
import com.a2driano.sity.my.weather.domain.interactors.IteractorWeatherProvider;
import com.a2driano.sity.my.weather.utils.converter.WeatherConverter;
import com.a2driano.sity.my.weather.view.application.App;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class WeatherProvider implements IteractorWeatherProvider, BoundaryCurrentWeather {
    private long cityId;
    private String units;

    public WeatherProvider(long cityId, String units) {
        this.cityId = cityId;
        this.units = units;
    }

    @Override
    public WeatherDAO getCurrentWeather() {
        return WeatherConverter.convertDTOtoDAO(getCurrentWeatherFromServer());
    }

    @Override
    public WeatherDTO getCurrentWeatherFromServer() {
        final WeatherDTO[] weatherDTO = {new WeatherDTO()};
        App.getWeatherAPI().getResponse(cityId, App.WEATHER_API, units).enqueue(new Callback<List<WeatherDTO>>() {
            @Override
            public void onResponse(Call<List<WeatherDTO>> call, Response<List<WeatherDTO>> response) {
                if (response.body() != null) {
//                    Log.d("probe download", "******************* weatherDTO[0] = response.body().get(0): " + response.body().get(0).toString());
                    weatherDTO[0] = response.body().get(0);
                }
            }

            @Override
            public void onFailure(Call<List<WeatherDTO>> call, Throwable t) {
                Log.d("probe download", "******************* onFailure");
                //error
            }
        });
        return weatherDTO[0];
    }
}
