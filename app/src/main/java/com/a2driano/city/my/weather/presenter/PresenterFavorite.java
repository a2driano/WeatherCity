package com.a2driano.city.my.weather.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.domain.application.App;
import com.bumptech.glide.Glide;

import java.util.List;

import static com.a2driano.city.my.weather.domain.application.App.getDataDelivery;

/**
 * Created by a2driano on 18.09.2017.
 */

public class PresenterFavorite {
    private Context mContext;
    private WeatherDAO mWeather;
    private LinearLayout mContainer;

    public PresenterFavorite(Context context) {
        mContext = context;
    }

    public void loadFavorites(LinearLayout view) {
        mContainer = view;
        List<WeatherDAO> listWeather = App.getDataDelivery().getCityWeathers();
        if (!listWeather.isEmpty()) {
            for (WeatherDAO weather : listWeather) {
                bindingView(weather);
            }
        }
    }

    public void deleteCityFromFavorites() {
        getDataDelivery().addCityWeather(mWeather);
    }

    /**
     * When response is success - binding data to GroupView
     */
    private void bindingView(WeatherDAO weather) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.container_for_favorite_weather, null);
//        TextView name = (TextView) view.findViewById(R.id.bg);

        //icon
        ImageView WeatherIcon = (ImageView) view.findViewById(R.id.icon_weather);
        //text view`s
        TextView CityName = (TextView) view.findViewById(R.id.city_name_text);
        TextView Temperature = (TextView) view.findViewById(R.id.temperature_main_text);
        TextView CloudWeather = (TextView) view.findViewById(R.id.cloud_info);
        //set text
        CityName.setText(weather.getCityName());
        Temperature.setText("" + weather.getTemp());
        CloudWeather.setText(weather.getDescription());
        //load icon from server
        Glide.with(mContext).load(weather.getIconDownloadUrl()).into(WeatherIcon);

        mContainer.addView(view);
//        //animation
//        mView.setVisibility(View.VISIBLE);
//        visibleAnimation(mContext, mView);
    }


}
