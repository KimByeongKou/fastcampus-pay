package com.fastcampuspay.membership.application.saga;

import lombok.Data;

@Data
public class OrderPlacedEvent  {

    private String orderId;

    private String name;


    public OrderPlacedEvent(){
        orderId = "default-123";
    }

    public OrderPlacedEvent(String orderId){
        this.orderId = orderId;
    }

    public OrderPlacedEvent(String orderId, String name){
        this.orderId = orderId;
        this.name = name;
    }
}