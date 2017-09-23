package com.a2driano.city.my.weather.data.repository.process;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.a2driano.city.my.weather.data.repository.model.WeatherDAO;

import static com.a2driano.city.my.weather.data.repository.shema.WeatherDBShema.WeatherTable.Cols;

/**
 * Created by a2driano on 19.09.2017.
 */

public class WeatherCursorWrapper extends CursorWrapper {
    private Cursor cursor;

    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public WeatherCursorWrapper(Cursor cursor) {
        super(cursor);
        this.cursor = cursor;
    }

    public WeatherDAO getCityWeather() {
        long cityId = getLong(getColumnIndex(Cols.CITY_ID));
        String cityName = getString(getColumnIndex(Cols.CITY_NAME));
        long date = getLong(getColumnIndex(Cols.DATE));
        long visibility = getLong(getColumnIndex(Cols.VISIBILITY));
        long allClouds = getLong(getColumnIndex(Cols.CLOUDS));
        long pressure = getLong(getColumnIndex(Cols.PRESSURE));
        long humidity = getLong(getColumnIndex(Cols.HUMIDITY));
        double tempMin = getLong(getColumnIndex(Cols.TEMP_MIN));
        double tempMax = getLong(getColumnIndex(Cols.TEMP_MAX));
        double temp = getDouble(getColumnIndex(Cols.TEMPERATURE));
        long sunrise = getLong(getColumnIndex(Cols.SUNRISE));
        long sunset = getLong(getColumnIndex(Cols.SUNSET));
        String countryIndex = getString(getColumnIndex(Cols.COUNTRY_INDEX));
        long weatherId = getLong(getColumnIndex(Cols.WEATHER_ID));
        String mainWeather = getString(getColumnIndex(Cols.MAIN_WEATHER));
        String description = getString(getColumnIndex(Cols.DESCRIPTION_WEATHER));
        String icon = getString(getColumnIndex(Cols.ICON_FILE_NAME));
        long speed = getLong(getColumnIndex(Cols.WIND_SPEED));
        long deg = getLong(getColumnIndex(Cols.WIND_DEG));

        WeatherDAO weatherDAO = new WeatherDAO();
        weatherDAO.setCityId(cityId);
        weatherDAO.setCityName(cityName);
        weatherDAO.setDate(date);
        weatherDAO.setVisibility(visibility);
        weatherDAO.setAllClouds(allClouds);
        weatherDAO.setPressure(pressure);
        weatherDAO.setHumidity(humidity);
        weatherDAO.setTempMin(tempMin);
        weatherDAO.setTempMax(tempMax);
        weatherDAO.setTemp(temp);
        weatherDAO.setSunrise(sunrise);
        weatherDAO.setSunset(sunset);
        weatherDAO.setCountryIndex(countryIndex);
        weatherDAO.setWeatherId(weatherId);
        weatherDAO.setMainWeather(mainWeather);
        weatherDAO.setDescription(description);
        weatherDAO.setIcon(icon);
        weatherDAO.setSpeed(speed);
        weatherDAO.setDeg(deg);

        return weatherDAO;
    }


//    public Level getLevel() {
//        int levelNumber = getInt(getColumnIndex(CatTable.Cols.LEVEL_NUMBER));
//        boolean isComplete = getInt(getColumnIndex(CatTable.Cols.LEVEL_COMPLETE)) > 0;//if >0 return true
//        boolean isOpen = getInt(getColumnIndex(CatTable.Cols.LEVEL_OPEN)) > 0;//if >0 return true
//
//        long time = getInt(getColumnIndex(CatTable.Cols.TIME_TO_FIND));
//
//        int x = getInt(getColumnIndex(CatTable.Cols.POINT_X));
//        int y = getInt(getColumnIndex(CatTable.Cols.POINT_Y));
//
//        Level level = new Level();
//        level.setLevelNumber(levelNumber);
//        level.setLevelComplete(isComplete);
//        level.setLevelOpen(isOpen);
//        level.setTimeToFind(time);
//        level.setXcoordinate(x);
//        level.setYcoordinate(y);
//
//        return level;
//    }
}
