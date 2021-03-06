package com.a2driano.city.my.weather.data.repository;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;

import java.util.List;

/**
 * Created by a2driano on 10.08.2017.
 */

public interface DataDelivery {
    public static final String DATABASE_NAME = "weather_db";

    /**
     * Get all Favorite weather
     */
    public List<WeatherDAO> getCityWeathers();

    /**
     * Get List of specific city weather from city index (5 days)
     */
    public List<WeatherDAO> getWeather(long cityIndex);

//    /**
//     * Get specific weather from city index
//     */
//    public WeatherDAO getWeather(int cityIndex);

    /**
     * Update weather data
     */
    public void updateCityWeather(WeatherDAO weatherDAO);

    /**
     * add city
     */
    public void addCityWeather(WeatherDAO weatherDAO);

    /**
     * add city`s
     */
    public void addCitiesWeather(List<WeatherDAO> weatherDAOList);

    /**
     * delete city by id
     */
    public void deleteCityWeather(long cityId);

    /**
     * delete city`s by id
     */
    public void deleteCitiesWeather(List<WeatherDAO> weatherDAOList);
}
