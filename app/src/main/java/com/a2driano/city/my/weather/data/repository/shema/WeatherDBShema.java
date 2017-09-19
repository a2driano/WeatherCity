package com.a2driano.city.my.weather.data.repository.shema;

/**
 * Created by a2driano on 19.09.2017.
 */

public class WeatherDBShema {
    public static final class WeatherTable {
        public static final String NAME = "table_weather";

        public static final class Cols {
            public static final String CITY_ID = "city_id";
            public static final String CITY_NAME = "city_name";
            public static final String DATE = "date";
            public static final String VISIBILITY = "visibility";
            public static final String CLOUDS = "clouds";
            public static final String PRESSURE = "pressure";
            public static final String HUMIDITY = "humidity";
            public static final String TEMP_MIN = "temp_min";
            public static final String TEMP_MAX = "temp_max";
            public static final String TEMPERATURE = "temp";
            public static final String SUNRISE = "sunrise";
            public static final String SUNSET = "sunset";
            public static final String COUNTRY_INDEX = "country_index";
            public static final String WEATHER_ID = "weatherId";
            public static final String MAIN_WEATHER = "mainWeather";
            public static final String DESCRIPTION_WEATHER = "description";
            public static final String ICON_FILE_NAME = "icon_file_name";
            public static final String WIND_SPEED = "wind_speed";
            public static final String WIND_DEG = "wind_deg";
        }
    }
}
