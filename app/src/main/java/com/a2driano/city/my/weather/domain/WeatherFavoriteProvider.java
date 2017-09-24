package com.a2driano.city.my.weather.domain;

import android.os.AsyncTask;
import android.util.Log;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.domain.application.App;
import com.a2driano.city.my.weather.domain.interactors.InteractorWeatherFavoriteProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Andrii Papai on 24.09.2017.
 */

public class WeatherFavoriteProvider extends AsyncTask<Void, Void, Void> {
    private long mTimeStepOpenWeather = 800L;
    private List<WeatherDAO> mFavoriteList;
    private InteractorWeatherFavoriteProvider delegate = null;

    public WeatherFavoriteProvider(InteractorWeatherFavoriteProvider delegate) {
        mFavoriteList = new ArrayList<>();
        this.delegate = delegate;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        List<WeatherDAO> list = App.getDataDelivery().getCityWeathers();
        HashSet<Long> cityIdList = detectIdFavoriteCity(list);
        mFavoriteList = getCurrentWeather(cityIdList, list);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //return List to presenter
        delegate.processFinish(mFavoriteList);
    }

    /**
     * Search for unique city id values
     */
    private HashSet<Long> detectIdFavoriteCity(List<WeatherDAO> list) {
        HashSet<Long> cityIdList = new HashSet<>();

        for (WeatherDAO weatherDao : list) {
            Long id = weatherDao.getCityId();
            cityIdList.add(id);
        }
        return cityIdList;
    }

    /**
     * Get WeatherDAO List with close time to current time
     */
    private List<WeatherDAO> getCurrentWeather(HashSet<Long> cityIdListHash, List<WeatherDAO> weatherDAOList) {
        List<WeatherDAO> favoriteWeatherDAO = new ArrayList<>();
        Long currentTime = System.currentTimeMillis() / 1000;

        for (Long idCurrent : cityIdListHash) {
            WeatherDAO timeCloseCityWeather = new WeatherDAO();
            List<WeatherDAO> temp = new ArrayList<>();
            long minimalDifferenceTime = 0;

            //find WeatherDAO with current cityId
            for (int j = 0; j < weatherDAOList.size(); j++) {
                if (idCurrent == weatherDAOList.get(j).getCityId()) {
                    temp.add(weatherDAOList.get(j));
                }
            }

            //find close date weather
            for (int j = 0; j < temp.size(); j++) {
                //first iteration
                if (j == 0) {
                    minimalDifferenceTime = Math.abs(currentTime - temp.get(j).getDate());
                    timeCloseCityWeather = temp.get(j);
                    continue;
                }
                if (minimalDifferenceTime > (Math.abs(currentTime - temp.get(j).getDate()))) {
                    timeCloseCityWeather = temp.get(j);
                }
            }
            //add closest Date weather to List
            favoriteWeatherDAO.add(timeCloseCityWeather);
        }
        return favoriteWeatherDAO;
    }
}
