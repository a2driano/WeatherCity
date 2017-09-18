package com.a2driano.city.my.weather.data.retrofit.model.component;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class Main {

    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("pressure")
    @Expose
    private long pressure;
    @SerializedName("humidity")
    @Expose
    private long humidity;
    @SerializedName("temp_min")
    @Expose
    private long tempMin;
    @SerializedName("temp_max")
    @Expose
    private long tempMax;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
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

}
