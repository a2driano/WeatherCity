package com.a2driano.city.my.weather.domain;

import android.util.Log;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.city.my.weather.domain.application.App;
import com.a2driano.city.my.weather.domain.boundaries.BoundaryCurrentWeather;
import com.a2driano.city.my.weather.domain.interactors.IteractorWeatherProvider;
import com.a2driano.city.my.weather.utils.converter.WeatherConverter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class WeatherProvider implements IteractorWeatherProvider, BoundaryCurrentWeather {
    private long id;
    private String units;
    private String appid;

    public WeatherProvider(long cityId, String units) {
        this.id = cityId;
        this.units = units;
    }

    @Override
    public WeatherDAO getCurrentWeather() {
        return WeatherConverter.convertDTOtoDAO(getCurrentWeatherFromServer());
//        getCurrentWeatherFromServer();
//        return new WeatherDAO();
    }

    @Override
    public WeatherDTO getCurrentWeatherFromServer() {
        appid = App.WEATHER_API;
        final WeatherDTO[] weatherDTO = {new WeatherDTO()};
        App.getWeatherAPI().getResponse(id, appid, units).enqueue(new Callback<WeatherDTO>() {
            @Override
            public void onResponse(Call<WeatherDTO> call, Response<WeatherDTO> response) {
                Log.d("probe download", "******************* response.isSuccessful(): " + response.isSuccessful());
                Log.d("probe download", "******************* response.code(): " + response.code());
                if (response.isSuccessful()) {
                    Log.d("probe download", "******************* response.isSuccessful(): " + response.isSuccessful());
                }
                if (response.body() != null) {
                    Log.d("probe download", "******************* weatherDTO[0] = response.body().get(0): " + response.body().toString());
                    weatherDTO[0] = response.body();
                }
            }

            @Override
            public void onFailure(Call<WeatherDTO> call, Throwable t) {
                Log.d("probe download", "******************* onFailure");
            }
        });
        return weatherDTO[0];
    }
}
