package com.a2driano.city.my.weather.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.domain.WeatherFavoriteProvider;
import com.a2driano.city.my.weather.domain.interactors.InteractorWeatherFavoriteProvider;
import com.a2driano.city.my.weather.utils.converter.TimeWeatherConverter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import static com.a2driano.city.my.weather.domain.application.App.getDataDelivery;

/**
 * Created by a2driano on 18.09.2017.
 */

public class PresenterFavorite {
    private Context mContext;
    private LinearLayout mContainer;
    private List<WeatherDAO> mListWeather;

    public PresenterFavorite(Context context) {
        mContext = context;
    }

    public void loadFavorites(LinearLayout view) {
        mContainer = view;
        new WeatherFavoriteProvider(new InteractorWeatherFavoriteProvider() {
            @Override
            public void processFinish(List<WeatherDAO> list) {
                mListWeather = list;
                //clear all child view
                if (mContainer.getChildCount() > 0)
                    mContainer.removeAllViews();

                if (!mListWeather.isEmpty()) {
                    for (WeatherDAO weather : mListWeather) {
                        bindingView(weather);
                    }
                }
            }
        }).execute();
    }

    /**
     * Delete city by tap to current button
     */
    public void deleteCityFromFavorites(ViewGroup deleteView) {
        WeatherDAO weatherDAO = (WeatherDAO) deleteView.getTag();
        long cityIndex = weatherDAO.getCityId();
        getDataDelivery().deleteCityWeather(cityIndex);
        if (deleteView.getChildCount() > 0)
            deleteView.removeAllViews();
    }

    /**
     * When response is success - binding data to GroupView
     */
    private void bindingView(WeatherDAO weather) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout viewWidget = (RelativeLayout) inflater.inflate(R.layout.container_for_favorite_weather, null);
        //add object WeatherDao
        viewWidget.setTag(weather);
        //icon
        ImageView WeatherIcon = (ImageView) viewWidget.findViewById(R.id.icon_weather);
        //text view`s
        TextView CityName = (TextView) viewWidget.findViewById(R.id.city_name_text);
        TextView Temperature = (TextView) viewWidget.findViewById(R.id.temperature_main_text);
        TextView CloudWeather = (TextView) viewWidget.findViewById(R.id.cloud_info);
        TextView DateTimeText = (TextView) viewWidget.findViewById(R.id.date_time_weather_text);
        //set text
        CityName.setText(weather.getCityName());
        Temperature.setText("" + weather.getTemp());
        CloudWeather.setText(weather.getDescription());
        DateTimeText.setText(TimeWeatherConverter.timeConverter(weather.getDate(), mContext));
        //load icon from server
        Glide.with(mContext).load(weather.getIconDownloadUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(WeatherIcon);

        Button button = (Button) viewWidget.findViewById(R.id.button_delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteCityFromFavorites(viewWidget);
            }
        });

        mContainer.addView(viewWidget);
    }
}
