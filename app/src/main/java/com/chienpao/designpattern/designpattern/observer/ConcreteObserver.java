package com.chienpao.designpattern.designpattern.observer;

/**
 * Created by pao on 3/16/16.
 */
public class ConcreteObserver implements IObserver {
    private static final String TAG = "Observer ConcreteObserver";

    @Override
    public void update(Event evt) {
        evt.doEvent();
    }
}
