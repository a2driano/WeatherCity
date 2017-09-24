package com.a2driano.city.my.weather.domain.interactors;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;

import java.util.List;

/**
 * Created by Andrii Papai on 24.09.2017.
 * <p>
 * implement this interface in Presenter,
 * for get List<WeatherDAO> from background
 * process
 */

public interface InteractorWeatherFavoriteProvider {
    void processFinish(List<WeatherDAO> list);
}
