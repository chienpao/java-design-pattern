package com.chienpao.designpattern.designpattern.observer;

import android.util.Log;

/**
 * Created by pao on 3/16/16.
 */
public class Event {
    private static final String TAG = "Observer Event";

    public Event() {
    }

    public void doEvent() {
        Log.v(TAG, "Do event");
    }
}
