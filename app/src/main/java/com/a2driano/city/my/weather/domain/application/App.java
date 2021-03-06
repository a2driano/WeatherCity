package com.a2driano.city.my.weather.domain.application;

import android.app.Application;

import com.a2driano.city.my.weather.data.repository.DataDelivery;
import com.a2driano.city.my.weather.data.repository.DataDeliveryImpl;
import com.a2driano.city.my.weather.data.retrofit.WeatherAPI;
import com.a2driano.city.my.weather.utils.message.manager.MessageManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class App extends Application {
    // Openweathermap.org key api
    public final static String WEATHER_API = "d2a6b21c943e38d9e44edcc03c9912ad";

    private static WeatherAPI mWeatherAPI;
    private static DataDelivery mDataDelivery;
    private static MessageManager sMessageManager;
    private Retrofit mRetrofit;

    private String url = "http://api.openweathermap.org/data/2.5/";

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mWeatherAPI = mRetrofit.create(WeatherAPI.class);

        mDataDelivery = new DataDeliveryImpl(getApplicationContext());

        sMessageManager = MessageManager.getMessageManager(this);
    }

    public static WeatherAPI getWeatherAPI() {
        return mWeatherAPI;
    }

    public static DataDelivery getDataDelivery() {
        return mDataDelivery;
    }

    public static MessageManager getMessageManager() {
        return sMessageManager;
    }
}
