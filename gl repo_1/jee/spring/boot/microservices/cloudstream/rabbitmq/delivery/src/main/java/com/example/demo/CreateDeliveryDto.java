package com.example.demo;

import java.util.Map;

public class CreateDeliveryDto {

    private String orderDate;


    private Map<String,Integer> items;

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Integer>getItems(){
        return items;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
