package com.a2driano.city.my.weather.data.retrofit.model.component;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrii Papai on 17.09.2017.
 */

public class Wind {

    @SerializedName("speed")
    @Expose
    private long speed;
    @SerializedName("deg")
    @Expose
    private long deg;

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
}
