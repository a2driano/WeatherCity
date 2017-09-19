package com.a2driano.city.my.weather.data.repository;

import android.content.Context;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.data.repository.process.DataLab;

import java.util.List;

/**
 * Created by a2driano on 19.09.2017.
 */

public class DataDeliveryImpl implements DataDelivery {
    private DataLab mDataLab;

    public DataDeliveryImpl(Context context) {
        mDataLab = DataLab.get(context);
    }

    @Override
    public List<WeatherDAO> getCityWeathers() {
        return mDataLab.getCityWeathers();
    }

    @Override
    public WeatherDAO getWeather(int cityIndex) {
        return mDataLab.getWeather(cityIndex);
    }

    @Override
    public void updateCityWeather(WeatherDAO weatherDAO) {
        mDataLab.updateCityWeather(weatherDAO);
    }

    @Override
    public void addCityWeather(WeatherDAO weatherDAO) {
        mDataLab.addCityWeather(weatherDAO);
    }

    @Override
    public void addCitiesWeather(List<WeatherDAO> weatherDAOList) {
        mDataLab.addCitiesWeather(weatherDAOList);
    }
}
