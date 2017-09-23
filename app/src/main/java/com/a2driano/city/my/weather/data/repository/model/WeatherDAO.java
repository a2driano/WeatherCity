package com.a2driano.city.my.weather.data.repository.model;

import java.util.Calendar;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class WeatherDAO {
    //common
    private long cityId;
    private String cityName;
    private long date;
    private long visibility;

    //clouds
    private long allClouds;

    //main
    private double pressure;
    private double humidity;
    private double tempMin;
    private double tempMax;
    private double temp;

    //sys
    private long sunrise;
    private long sunset;
    private String countryIndex;

    //weather
    private long weatherId;
    private String mainWeather; //exam: "main": "Rain"
    private String description; //exam: "description": "light rain"
    private String icon; //icon file name

    //wind
    private double speed;
    private double deg;

    public String getIconDownloadUrl() {
        return "http://openweathermap.org/img/w/" + icon + ".png";
    }

    public Calendar getCalendarDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date * 1000);
        return calendar;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public long getAllClouds() {
        return allClouds;
    }

    public void setAllClouds(long allClouds) {
        this.allClouds = allClouds;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public String getCountryIndex() {
        return countryIndex;
    }

    public void setCountryIndex(String countryIndex) {
        this.countryIndex = countryIndex;
    }

    public long getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(long weatherId) {
        this.weatherId = weatherId;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "WeatherDAO{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", date=" + date +
                ", visibility=" + visibility +
                ", allClouds=" + allClouds +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", temp=" + temp +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", countryIndex='" + countryIndex + '\'' +
                ", weatherId=" + weatherId +
                ", mainWeather='" + mainWeather + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
