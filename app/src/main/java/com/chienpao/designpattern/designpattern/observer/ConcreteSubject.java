package com.chienpao.designpattern.designpattern.observer;

import java.util.Vector;

/**
 * Created by pao on 3/16/16.
 */
public class ConcreteSubject implements ISubject{
    Vector<IObserver> mObservers = new Vector<>();

    @Override
    public void attach(IObserver observer) {
        mObservers.addElement(observer);
    }

    @Override
    public void detach(IObserver observer) {
        mObservers.removeElement(observer);
    }

    @Override
    public void inform() {
        Event evt = new Event();
        for(IObserver ob : mObservers){
            ob.update(evt);
        }
    }
}
