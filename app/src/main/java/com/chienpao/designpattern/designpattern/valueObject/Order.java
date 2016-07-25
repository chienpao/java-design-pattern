package com.chienpao.designpattern.designpattern.valueObject;

import java.io.Serializable;

/**
 * Created by pao on 3/16/16.
 */
public class Order implements Serializable{
    private int orderId;
    private String clientName;
    private String prodName;
    private int number;

    public Order(String clientName, String prodName, int number) {
        this.clientName = clientName;
        this.number = number;
        this.prodName = prodName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOrderid() {
        return orderId;
    }

    public void setOrderid(int orderId) {
        this.orderId = orderId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
