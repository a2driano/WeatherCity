package com.a2driano.city.my.weather.domain.interactors;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;

import java.util.List;

/**
 * Created by Andrii Papai on 23.09.2017.
 */

public interface IteractorWeatherDb {
    //return DAO of weather city for 5 days
    public List<WeatherDAO> getWeatherCityFromDB();
}
