package com.a2driano.city.my.weather.domain.interactors;

import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public interface InteractorCurrentWeatherServer {
    //return DTO current city for 1 day
    public WeatherDTO getCurrentWeatherFromServer();

}
