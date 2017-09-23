package com.a2driano.city.my.weather.domain;

import android.util.Log;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.city.my.weather.data.retrofit.model.WeatherForecastDTO;
import com.a2driano.city.my.weather.domain.application.App;
import com.a2driano.city.my.weather.domain.interactors.IteractorWeatherFromServerToDb;
import com.a2driano.city.my.weather.utils.message.manager.MessageManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.a2driano.city.my.weather.utils.converter.WeatherConverter.convertListDTOtoDAO;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class WeatherProvider implements IteractorWeatherFromServerToDb {
    private long cityId;
    private String units;
    private List<WeatherDTO> mWeatherDTOList;

    public WeatherProvider(long cityId, String units) {
        this.cityId = cityId;
        this.units = units;
        mWeatherDTOList = new ArrayList<>();
    }

    @Override
    public void getWeatherFromServer() {
        App.getWeatherAPI().getForecast(cityId, App.WEATHER_API, units).enqueue(new Callback<WeatherForecastDTO>() {
            @Override
            public void onResponse(Call<WeatherForecastDTO> call, Response<WeatherForecastDTO> response) {

                if (response.isSuccessful() & response.body() != null) {
                    WeatherForecastDTO forecast = response.body();
//                    List<WeatherDTO> list = forecast.getList();
                    mWeatherDTOList = forecast.getList();
                    if (mWeatherDTOList.size() > 0) {
                        saveWeatherToDb(mWeatherDTOList);//success
                        Log.d("Download Forecast", "******************* success!");
                    }
                } else if (response.code() != 200) {
                    MessageManager.getMessageServerError();
                    Log.d("Download response", "******************* response" + response.code());
                }
            }

            @Override
            public void onFailure(Call<WeatherForecastDTO> call, Throwable t) {
//                Toast.makeText(mContext, R.string.internet_error, Toast.LENGTH_SHORT).show();
                Log.d("Download Forecast", "******************* onFailure");
                MessageManager.getMessageInternetError();
            }
        });
    }

    @Override
    public void saveWeatherToDb(List<WeatherDTO> listDTO) {
        List<WeatherDAO> listDAO = convertListDTOtoDAO(listDTO);
        //add data to DB
        checkExistWeather(listDAO);
        MessageManager.getMessageSuccessAddCityToFavorite();
    }

    //check DB to get city from DB
    private void checkExistWeather(List<WeatherDAO> listDAO) {
        List<WeatherDAO> listDAOfromDB = App.getDataDelivery().getWeather(cityId);
        if (listDAOfromDB == null) {
            App.getDataDelivery().addCitiesWeather(listDAO);
        } else {
            //delete old data and set new data to DB
            if ((listDAOfromDB.size() > 0)) {
                App.getDataDelivery().deleteCitiesWeather(listDAOfromDB);
                App.getDataDelivery().addCitiesWeather(listDAO);
            }
        }
    }
}
