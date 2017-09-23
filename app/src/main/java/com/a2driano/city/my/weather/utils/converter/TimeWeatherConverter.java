package com.a2driano.city.my.weather.utils.converter;

import android.content.Context;
import android.text.format.DateUtils;

import com.a2driano.city.my.weather.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Andrii Papai on 23.09.2017.
 */

public class TimeWeatherConverter {

    public static String timeConverter(long date, Context context) {

        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTimeInMillis(date * 1000);
        SimpleDateFormat formatDayOfWeek = new SimpleDateFormat("MMM dd, kk:mm");

        String dateString;
        //check this day is today
//        if (DateUtils.isToday(date)) {
        if (DateUtils.isToday(dateCalendar.getTimeInMillis())) {
            dateString = context.getString(R.string.date_today);
        } else {
            dateString = formatDayOfWeek.format(dateCalendar.getTime());
        }

        return dateString;
    }
}
