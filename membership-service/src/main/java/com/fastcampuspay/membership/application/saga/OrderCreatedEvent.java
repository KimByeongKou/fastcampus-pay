package com.fastcampuspay.membership.application.saga;

public class OrderCreatedEvent {

    private String orderId;
    private String customerName;

    public OrderCreatedEvent(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }
}