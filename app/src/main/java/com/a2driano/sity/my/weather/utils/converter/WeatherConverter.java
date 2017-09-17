package com.a2driano.sity.my.weather.utils.converter;

import android.util.Log;

import com.a2driano.sity.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.sity.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.sity.my.weather.domain.WeatherProvider;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class WeatherConverter {

    //convert DTO to DAO
    public static WeatherDAO convertDTOtoDAO(WeatherDTO weatherDTO) {
        Log.d("probe download", "******************* : " + weatherDTO.toString());
        WeatherDAO weatherDAO = new WeatherDAO();
        weatherDAO.setCityId(weatherDTO.getId());
        weatherDAO.setCityName(weatherDTO.getName());
        weatherDAO.setDate(weatherDTO.getDt());
        weatherDAO.setVisibility(weatherDTO.getVisibility());
        weatherDAO.setAllClouds(weatherDTO.getClouds().getAll());
        weatherDAO.setPressure(weatherDTO.getMain().getPressure());
        weatherDAO.setHumidity(weatherDTO.getMain().getHumidity());
        weatherDAO.setTempMin(weatherDTO.getMain().getTempMin());
        weatherDAO.setTempMax(weatherDTO.getMain().getTempMax());
        weatherDAO.setSunrise(weatherDTO.getSys().getSunrise());
        weatherDAO.setSunset(weatherDTO.getSys().getSunset());
        weatherDAO.setCountryIndex(weatherDTO.getSys().getCountry());
        weatherDAO.setWeatherId(weatherDTO.getWeather().get(0).getId());
        weatherDAO.setMainWeather(weatherDTO.getWeather().get(0).getMain());
        weatherDAO.setDescription(weatherDTO.getWeather().get(0).getDescription());
        weatherDAO.setIcon(weatherDTO.getWeather().get(0).getIcon());
        weatherDAO.setSpeed(weatherDTO.getWind().getSpeed());
        weatherDAO.setDeg(weatherDTO.getWind().getDeg());

        return weatherDAO;
    }
}
