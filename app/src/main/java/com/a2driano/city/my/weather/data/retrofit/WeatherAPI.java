package com.a2driano.city.my.weather.data.retrofit;

import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public interface WeatherAPI {
    @GET("weather")
    Call<WeatherDTO> getResponse(
            @Query("q") String name,
            @Query("appid") String appid,
            @Query("units") String units
    );
//    @GET("weather")
//    Call<WeatherDTO> getResponse(
//            @Query("id") Long id,
//            @Query("appid") String appid,
//            @Query("units") String units
//    );
//    @GET("weather")
//    Call<List<WeatherDTO>> getResponse(
//            @Query("id") Long id,
//            @Query("appid") String appid,
//            @Query("units") String units
//    );

//    http://api.openweathermap.org/data/2.5/weather?id=709930&appid=d2a6b21c943e38d9e44edcc03c9912ad&units=metric
}
