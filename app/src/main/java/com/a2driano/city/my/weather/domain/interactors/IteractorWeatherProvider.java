package com.a2driano.city.my.weather.domain.interactors;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public interface IteractorWeatherProvider {
    /** Return weather of searching city */
    public WeatherDAO getCurrentWeather();
}
