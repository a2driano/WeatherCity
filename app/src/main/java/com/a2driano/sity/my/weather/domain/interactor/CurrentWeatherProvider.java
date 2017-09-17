package com.a2driano.sity.my.weather.domain.interactor;

import com.a2driano.sity.my.weather.data.repository.model.WeatherDAO;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public interface CurrentWeatherProvider {
    /** Return weather of searching city */
    public WeatherDAO getCurrentWeather();
}
