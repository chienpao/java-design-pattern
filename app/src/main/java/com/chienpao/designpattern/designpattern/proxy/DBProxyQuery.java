package com.chienpao.designpattern.designpattern.proxy;

/**
 * Created by pao on 2/29/16.
 */
public class DBProxyQuery implements InterfaceDBQuery {

    private static final String TAG = "DBProxyQuery";

    private DBQuery mDBQuery = null;

    @Override
    public String request() {
        if (mDBQuery == null)
            mDBQuery = new DBQuery();
        return mDBQuery.request();
    }
}
