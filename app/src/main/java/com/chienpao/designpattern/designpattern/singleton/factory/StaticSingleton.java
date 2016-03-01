package com.chienpao.designpattern.designpattern.singleton.factory;

import android.util.Log;

/**
 * Created by pao on 2/29/16.
 */
public class StaticSingleton {
    private static final String TAG = "StaticSingleton";

    private StaticSingleton() {
        Log.v(TAG, "StaticSingleton is create.");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

}
