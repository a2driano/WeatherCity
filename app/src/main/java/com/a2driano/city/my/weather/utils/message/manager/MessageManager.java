package com.a2driano.city.my.weather.utils.message.manager;

import android.content.Context;
import android.widget.Toast;

import com.a2driano.city.my.weather.R;

/**
 * Created by Andrii Papai on 23.09.2017.
 * <p>
 * Message toasts
 */

public class MessageManager {
    private static MessageManager mMessageManager;
    private static Context mContext;

    private MessageManager(Context context) {
        mContext = context;
    }

    public static MessageManager getMessageManager(Context context) {
        if (mMessageManager == null) {
            return new MessageManager(context);
        }
        return mMessageManager;
    }

    public static void getMessageSuccessAddCityToFavorite() {
        Toast.makeText(mContext, R.string.add_to_favorite, Toast.LENGTH_SHORT).show();
    }

    public static void getMessageServerError() {
        Toast.makeText(mContext, R.string.internet_error_server, Toast.LENGTH_SHORT).show();
    }

    public static void getMessageInternetError() {
        Toast.makeText(mContext, R.string.internet_error, Toast.LENGTH_SHORT).show();
    }

    public static void getMessageCityNameError() {
        Toast.makeText(mContext, R.string.city_name_error, Toast.LENGTH_SHORT).show();
    }

    public static void getMessageEmptyName() {
        Toast.makeText(mContext, R.string.edit_text_is_empty, Toast.LENGTH_SHORT).show();
    }
}
