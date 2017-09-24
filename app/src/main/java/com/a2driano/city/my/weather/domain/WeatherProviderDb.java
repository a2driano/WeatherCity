package com.a2driano.city.my.weather.domain;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.domain.interactors.InteractorWeatherDb;

import java.util.List;

/**
 * Created by Andrii Papai on 23.09.2017.
 */

public class WeatherProviderDb implements InteractorWeatherDb {

    @Override
    public List<WeatherDAO> getWeatherCityFromDB() {
        return null;
    }
}
