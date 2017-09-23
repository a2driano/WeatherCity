package com.a2driano.city.my.weather.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.data.retrofit.model.WeatherDTO;
import com.a2driano.city.my.weather.domain.WeatherProvider;
import com.a2driano.city.my.weather.domain.application.App;
import com.a2driano.city.my.weather.domain.interactors.IteractorCurrentWeatherServer;
import com.a2driano.city.my.weather.utils.message.manager.MessageManager;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.a2driano.city.my.weather.utils.converter.WeatherConverter.convertDTOtoDAO;
import static com.a2driano.city.my.weather.utils.animation.AnimationCommon.visibleAnimation;

/**
 * Created by a2driano on 18.09.2017.
 */

public class PresenterSearch implements IteractorCurrentWeatherServer {
    private Context mContext;
    private String mCityName;
    private String mUnits;
    private View mView;
    private WeatherDAO mWeather;

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
                    bindingView(convertDTOtoDAO(response.body()));
                } else if (response.code() != 404) {
//                    Toast.makeText(mContext, R.string.city_name_error, Toast.LENGTH_SHORT).show();
                    MessageManager.getMessageCityNameError();
                    Log.d("Download", "******************* response.code() == 404");
                }
            }

            @Override
            public void onFailure(Call<WeatherDTO> call, Throwable t) {
//                Toast.makeText(mContext, R.string.internet_error, Toast.LENGTH_SHORT).show();
                MessageManager.getMessageInternetError();
                Log.d("Download", "******************* onFailure");
            }
        });
        return weatherDTO[0];
    }

    public void addCityToFavorites() {
//        App.getDataDelivery().addCityWeather(mWeather);
//        Log.d("Download message", "******************* mWeather.getCityId()" + mWeather.getCityId());
//        Log.d("Download message", "******************* mWeather.mUnits" + mUnits);
//        Toast.makeText(mContext, mContext.getText(message), Toast.LENGTH_SHORT).show();
        new WeatherProvider(mWeather.getCityId(), mUnits).getWeatherFromServer();
    }

    /**
     * When response is success - binding data to GroupView
     */
    private void bindingView(WeatherDAO weather) {
        mWeather = weather;
        //icon
        ImageView WeatherIcon = (ImageView) mView.findViewById(R.id.icon_weather);
        //text view`s
        TextView CityName = (TextView) mView.findViewById(R.id.city_name_text);
        TextView Temperature = (TextView) mView.findViewById(R.id.temperature_main_text);
        TextView CloudWeather = (TextView) mView.findViewById(R.id.cloud_info);
        //set text
        CityName.setText(weather.getCityName());
        Temperature.setText("" + weather.getTemp());
        CloudWeather.setText(weather.getDescription());
        //load icon from server
        Glide.with(mContext).load(weather.getIconDownloadUrl()).into(WeatherIcon);
        Log.d("Icon bindingView", "******************* weather.getIconDownloadUrl():" + weather.getIconDownloadUrl());
        //animation
        mView.setVisibility(View.VISIBLE);
        visibleAnimation(mContext, mView);

        //hide keyboard
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
