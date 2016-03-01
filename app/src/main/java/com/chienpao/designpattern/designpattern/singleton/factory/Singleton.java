package com.chienpao.designpattern.designpattern.singleton.factory;

import android.util.Log;

/**
 * Created by pao on 2/29/16.
 */
public class Singleton {
    private static final String TAG = "Singleton";

    private Singleton() {
        Log.v(TAG, "Singleton is create.");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void createString(){
        Log.v(TAG, "createString in Singleton");
    }
}
