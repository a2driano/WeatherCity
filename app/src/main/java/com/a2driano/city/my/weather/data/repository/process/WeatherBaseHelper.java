package com.a2driano.city.my.weather.data.repository.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.a2driano.city.my.weather.data.repository.shema.WeatherDBShema.WeatherTable;

import static com.a2driano.city.my.weather.data.repository.DataDelivery.DATABASE_NAME;

/**
 * Created by a2driano on 19.09.2017.
 */

public class WeatherBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    Context mContext;

    public WeatherBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        mContext = context;
    }

    public WeatherBaseHelper(Context context, SQLiteDatabase database) {
        super(context, DATABASE_NAME, null, VERSION);
        mContext = context;
    }

    public WeatherBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + WeatherTable.NAME
                + "(" + " _id integer primary key autoincrement, " +
                WeatherTable.Cols.CITY_ID + " integer, " +
                WeatherTable.Cols.CITY_NAME + ", " +
                WeatherTable.Cols.DATE + " integer, " +
                WeatherTable.Cols.VISIBILITY + " integer, " +
                WeatherTable.Cols.CLOUDS + " integer, " +
                WeatherTable.Cols.PRESSURE + " integer, " +
                WeatherTable.Cols.HUMIDITY + " integer, " +
                WeatherTable.Cols.TEMP_MIN + " integer, " +
                WeatherTable.Cols.TEMP_MAX + " integer, " +
                WeatherTable.Cols.TEMPERATURE + " real, " +
                WeatherTable.Cols.SUNRISE + " integer, " +
                WeatherTable.Cols.SUNSET + " integer, " +
                WeatherTable.Cols.COUNTRY_INDEX + ", " +
                WeatherTable.Cols.WEATHER_ID + " integer, " +
                WeatherTable.Cols.MAIN_WEATHER + ", " +
                WeatherTable.Cols.DESCRIPTION_WEATHER + ", " +
                WeatherTable.Cols.ICON_FILE_NAME + ", " +
                WeatherTable.Cols.WIND_SPEED + " integer, " +
                WeatherTable.Cols.WIND_DEG + " integer" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
