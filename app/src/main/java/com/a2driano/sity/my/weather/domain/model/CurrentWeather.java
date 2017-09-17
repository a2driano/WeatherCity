package com.a2driano.sity.my.weather.domain.model;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class CurrentWeather {
    //common
    private long cityId;
    private String cityName;
    private long date;
    private long visibility;

    //clouds
    private long all;

    //main
    private long pressure;
    private long humidity;
    private long tempMin;
    private long tempMax;

    //sys
    private long sunrise;
    private long sunset;
    private String countryIndex;

    //weather
    private long weatherId;
    private String mainWeather; //exam: "main": "Rain"
    private String description; //exam: "description": "light rain"
    private String icon; //icon name file

    //wind
    private long speed;
    private long deg;
}
