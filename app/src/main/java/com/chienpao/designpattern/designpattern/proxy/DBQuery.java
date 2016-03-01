package com.chienpao.designpattern.designpattern.proxy;

/**
 * Created by pao on 2/29/16.
 */
public class DBQuery implements InterfaceDBQuery {

    private static final String TAG = "DBQuery";

    public DBQuery() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return null;
    }
}
