package com.a2driano.city.my.weather.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.a2driano.city.my.weather.domain.WeatherProvider;

/**
 * Created by a2driano on 18.09.2017.
 */

public class PresenterSearch {
    private Context mContext;
    private long mCityId;
    private String mUnits;

    public PresenterSearch(Context context) {
        mContext = context;
    }

    public void searchCityWheather(long cityId, String units) {
        mCityId = cityId;
        mUnits = units;
        new AsyncSearch().execute();
    }

    private class AsyncSearch extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            long cityId = mCityId;
            String units = mUnits;
            new WeatherProvider(cityId, units).getCurrentWeather();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
