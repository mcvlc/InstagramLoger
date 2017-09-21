package com.project.darkhorsestd.instagramloger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class InstaLogerApplication extends Application {

    public static SharedPreferences sSharedPreferences;

    private static Context sContext;


    public static Context getContext() {
        return sContext;
    }

    /**
     * Создаёт SharedPreferences
     */
    @Override
    public void onCreate(){
        super.onCreate();
        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sContext = getApplicationContext();

    }

    /**
     * Получает SharedPreferences
     * @return SharedPreferences
     */
    public static SharedPreferences getsSharedPreferences() {
        return sSharedPreferences;
    }
}

