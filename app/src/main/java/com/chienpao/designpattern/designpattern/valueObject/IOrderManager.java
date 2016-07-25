package com.chienpao.designpattern.designpattern.valueObject;

/**
 * Created by pao on 3/16/16.
 */
public interface IOrderManager {
    public Order getOrder(int id);

    public String getClientName(int id);

    public String getProdName(int id);

    public int getNumber(int id);
}
