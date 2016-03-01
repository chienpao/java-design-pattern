package com.chienpao.designpattern.designpattern.singleton.factory;

import android.util.Log;

/**
 * Created by pao on 2/29/16.
 */
public class LazySingleton {
    private static final String TAG = "LazySingleton";

    private LazySingleton() {
        Log.v(TAG, "LazySingleton is create.");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {

        if (instance == null)
            instance = new LazySingleton();

        return instance;
    }
}
