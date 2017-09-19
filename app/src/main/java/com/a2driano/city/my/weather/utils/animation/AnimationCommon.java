package com.a2driano.city.my.weather.utils.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.a2driano.city.my.weather.R;


/**
 * Created by a2driano
 */

public class AnimationCommon {
    public static void visibleAnimation(Context context, View view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.temperature_layout_visible);
        view.startAnimation(animation);
    }


    public static void hideAnimation(Context context, View view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.temperature_layout_gone);
        view.startAnimation(animation);
    }

}
