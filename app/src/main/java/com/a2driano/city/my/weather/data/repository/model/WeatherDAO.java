package com.a2driano.city.my.weather.data.repository.model;

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
    private long pressure;
    private long humidity;
    private long tempMin;
    private long tempMax;
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
    private long speed;
    private long deg;

    public String getIconDownloadUrl() {
        return "http://openweathermap.org/img/w/" + icon + ".png";
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
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

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getTempMin() {
        return tempMin;
    }

    public void setTempMin(long tempMin) {
        this.tempMin = tempMin;
    }

    public long getTempMax() {
        return tempMax;
    }

    public void setTempMax(long tempMax) {
        this.tempMax = tempMax;
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

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public long getDeg() {
        return deg;
    }

    public void setDeg(long deg) {
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
