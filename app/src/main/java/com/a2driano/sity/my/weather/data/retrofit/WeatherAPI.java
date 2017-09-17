package com.a2driano.sity.my.weather.data.retrofit;

import com.a2driano.sity.my.weather.data.retrofit.model.WeatherDTO;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public interface WeatherAPI {
    @GET("/weather?")
    void getResponse(
            @Query("id") Long cityId,
            @Query("appid") String apiKey,
            @Query("units") String units,
            Callback<List<WeatherDTO>> response
    );
//    http://api.openweathermap.org/data/2.5/weather?id=709930&appid=d2a6b21c943e38d9e44edcc03c9912ad&units=metric
}
