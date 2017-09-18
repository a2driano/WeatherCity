package com.a2driano.city.my.weather.domain;

import android.util.Log;

import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.city.my.weather.domain.application.App;
import com.a2driano.city.my.weather.domain.interactors.IteractorCurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class WeatherProvider implements IteractorCurrentWeather {
    private String cityId;
    private String units;
    private String appid;

    public WeatherProvider(String cityId, String units) {
        this.cityId = cityId;
        this.units = units;
    }

//    @Override
//    public WeatherDAO getCurrentWeather() {
////        return WeatherConverter.convertDTOtoDAO(getCurrentWeatherFromServer());
//        getCurrentWeatherFromServer();
//        return new WeatherDAO();
//    }

    @Override
    public WeatherDTO getCurrentWeatherFromServer() {
        appid = App.WEATHER_API;
        final WeatherDTO[] weatherDTO = {new WeatherDTO()};
        App.getWeatherAPI().getResponse(cityId, appid, units).enqueue(new Callback<WeatherDTO>() {
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
