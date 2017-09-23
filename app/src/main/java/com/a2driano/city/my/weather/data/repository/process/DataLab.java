package com.a2driano.city.my.weather.data.repository.process;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;
import com.a2driano.city.my.weather.data.repository.shema.WeatherDBShema.WeatherTable;
import com.a2driano.city.my.weather.data.repository.shema.WeatherDBShema.WeatherTable.Cols;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a2driano on 19.09.2017.
 */

public class DataLab {
    private static DataLab sDataLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private DataLab(Context context) throws IOException {
        mContext = context.getApplicationContext();
        mDatabase = new WeatherBaseHelper(mContext)
                .getWritableDatabase();
    }

    //access to the DataLab class
    public static DataLab get(Context context) {
        if (sDataLab != null)
            return sDataLab;
        try {
            return new DataLab(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<WeatherDAO> getWeather(long cityIndex) {
        List<WeatherDAO> levelList = new ArrayList<>();
        WeatherCursorWrapper cursor = queryLevels(
                Cols.CITY_ID + " = ?",
                new String[]{String.valueOf(cityIndex)}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                levelList.add(cursor.getCityWeather());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return levelList;
    }

    public List<WeatherDAO> getCityWeathers() {
        List<WeatherDAO> levelList = new ArrayList<>();
        WeatherCursorWrapper cursor = queryLevels(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                levelList.add(cursor.getCityWeather());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return levelList;
    }

    public void addCityWeather(WeatherDAO weather) {
        ContentValues values = getContentValues(weather);
        mDatabase.insert(WeatherTable.NAME, null, values);
    }

    public void updateCityWeather(WeatherDAO weather) {
        long number = weather.getCityId();
        ContentValues values = getContentValues(weather);

        mDatabase.update(WeatherTable.NAME, values,
                Cols.CITY_ID + " = ?", new String[]{"" + number});
    }

    public void deleteCityWeather(long number) {
        mDatabase.delete(WeatherTable.NAME,
                Cols.CITY_ID + " = ?", new String[]{"" + number});
    }

    public void deleteCitiesWeather(List<WeatherDAO> citiesWeather) {
        for (WeatherDAO cities : citiesWeather) {
            deleteCityWeather(cities.getCityId());
        }
    }

    public void addCitiesWeather(List<WeatherDAO> citiesWeather) {
        for (WeatherDAO cities : citiesWeather) {
            addCityWeather(cities);
        }
    }

    private WeatherCursorWrapper queryLevels(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                WeatherTable.NAME,
                null, // Columns - null take all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new WeatherCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(WeatherDAO weather) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Cols.CITY_ID, weather.getCityId());
        contentValues.put(Cols.CITY_NAME, weather.getCityName());
        contentValues.put(Cols.DATE, weather.getDate());
        contentValues.put(Cols.VISIBILITY, weather.getVisibility());
        contentValues.put(Cols.CLOUDS, weather.getAllClouds());
        contentValues.put(Cols.PRESSURE, weather.getPressure());
        contentValues.put(Cols.HUMIDITY, weather.getHumidity());
        contentValues.put(Cols.TEMP_MIN, weather.getTempMin());
        contentValues.put(Cols.TEMP_MAX, weather.getTempMax());
        contentValues.put(Cols.TEMPERATURE, weather.getTemp());
        contentValues.put(Cols.SUNRISE, weather.getSunrise());
        contentValues.put(Cols.SUNSET, weather.getSunset());
        contentValues.put(Cols.COUNTRY_INDEX, weather.getCountryIndex());
        contentValues.put(Cols.WEATHER_ID, weather.getWeatherId());
        contentValues.put(Cols.MAIN_WEATHER, weather.getMainWeather());
        contentValues.put(Cols.DESCRIPTION_WEATHER, weather.getDescription());
        contentValues.put(Cols.ICON_FILE_NAME, weather.getIcon());
        contentValues.put(Cols.WIND_SPEED, weather.getSpeed());
        contentValues.put(Cols.CITY_ID, weather.getCityId());
        contentValues.put(Cols.WIND_DEG, weather.getDeg());

        return contentValues;
    }

    public void clearTable() {
        mDatabase.execSQL("delete from " + WeatherTable.NAME);
    }
}
