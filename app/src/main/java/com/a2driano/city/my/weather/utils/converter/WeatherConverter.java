package com.a2driano.city.my.weather.utils.converter;

import android.util.Log;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class WeatherConverter {

    //convert DTO to DAO
    public static WeatherDAO convertDTOtoDAO(WeatherDTO weatherDTO) {
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
        weatherDAO.setTemp(weatherDTO.getMain().getTemp());
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

    //convert List`s DTO to DAO
    public static List<WeatherDAO> convertListDTOtoDAO(List<WeatherDTO> weatherDTOList) {
        List<WeatherDAO> weatherDAOList = new ArrayList<>();
        for (WeatherDTO weather : weatherDTOList) {
            weatherDAOList.add(convertDTOtoDAO(weather));
        }

        return weatherDAOList;
    }
}
