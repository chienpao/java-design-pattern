package com.chienpao.designpattern.designpattern.valueObject;

/**
 * Created by pao on 3/16/16.
 */
public class OrderManager implements IOrderManager{

    @Override
    public Order getOrder(int id) {
        // clientName, prodName, number
        Order order = new Order("Pao", "designPattern", 6);
        return order;
    }

    @Override
    public String getClientName(int id) {
        return "Pao";
    }

    @Override
    public String getProdName(int id) {
        return "designPattern";
    }

    @Override
    public int getNumber(int id) {
        return 6;
    }

}
