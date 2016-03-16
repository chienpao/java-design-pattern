package com.chienpao.designpattern.designpattern.observer;

/**
 * Created by pao on 3/16/16.
 */
public interface ISubject {
    void attach(IObserver observer);

    void detach(IObserver observer);

    void inform();
}
