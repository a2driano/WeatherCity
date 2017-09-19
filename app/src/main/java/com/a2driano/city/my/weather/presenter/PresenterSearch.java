package com.a2driano.city.my.weather.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.city.my.weather.domain.application.App;
import com.a2driano.city.my.weather.domain.interactors.IteractorCurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.a2driano.city.my.weather.utils.converter.WeatherConverter.convertDTOtoDAO;
import static com.a2driano.city.my.weather.utils.converter.animation.AnimationCommon.visibleAnimation;

/**
 * Created by a2driano on 18.09.2017.
 */

public class PresenterSearch implements IteractorCurrentWeather {
    private Context mContext;
    private String mCityName;
    private String mUnits;
    private View mView;

    public PresenterSearch(Context context) {
        mContext = context;
    }

    public void searchCityWeather(String cityName, String units, View view) {
        mCityName = cityName;
        mUnits = units;
        mView = view;
//        WeatherDAO weather = new WeatherProvider(cityId, units).getCurrentWeather();
        //get weather
        getCurrentWeatherFromServer();
//        Log.d("PresenterSearch", "******************* weather.toString(): " + weather.toString());
//        new AsyncSearch().execute();
    }


    @Override
    public WeatherDTO getCurrentWeatherFromServer() {
        final WeatherDTO[] weatherDTO = {new WeatherDTO()};
        App.getWeatherAPI().getResponse(mCityName, App.WEATHER_API, mUnits).enqueue(new Callback<WeatherDTO>() {
            @Override
            public void onResponse(Call<WeatherDTO> call, Response<WeatherDTO> response) {
                if (response.isSuccessful() & response.body() != null) {
//                    weatherDTO[0] = response.body();
                    bindingView(convertDTOtoDAO(response.body()));
                    Log.d("Download", "******************* weatherDTO[0] = response.body().get(0): " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<WeatherDTO> call, Throwable t) {
                Toast.makeText(mContext, R.string.city_name_error, Toast.LENGTH_SHORT).show();
                Log.d("Download", "******************* onFailure");
            }
        });
        return weatherDTO[0];
    }

    private void bindingView(WeatherDAO weather) {
        //icon
        ImageView WeatherIcon = (ImageView) mView.findViewById(R.id.icon_weather);
        //text view`s
        TextView CityName = (TextView) mView.findViewById(R.id.city_name_text);
        TextView Temperature = (TextView) mView.findViewById(R.id.temperature_main_text);
        TextView CloudWeather = (TextView) mView.findViewById(R.id.cloud_info);

        CityName.setText(weather.getCityName());
        Temperature.setText("" + weather.getTemp());
        CloudWeather.setText(weather.getDescription());

        //animation
        mView.setVisibility(View.VISIBLE);
        visibleAnimation(mContext, mView);
    }
}
