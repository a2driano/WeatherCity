package com.a2driano.city.my.weather.domain.interactors;

import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.city.my.weather.data.retrofit.model.WeatherForecastDTO;

import java.util.List;

/**
 * Created by Andrii Papai on 23.09.2017.
 * <p>
 * Download 5 day weather from server and save in DB
 */

public interface InteractorWeatherFromServerToDb {
    /**
     * Get weather from server (Forecast - 5 day)
     */
    public void getWeatherFromServer();

    /**
     * Save List<WeatherDTO> to DB.
     * If exist - update, else - create.
     *
     * @param weatherForecastDTO
     */
    public void saveWeatherToDb(WeatherForecastDTO weatherForecastDTO);
}
