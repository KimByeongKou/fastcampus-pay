package com.fastcampuspay.membership.application.saga;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderCancelledEvent {
    private String orderId;
    private String paymentId;
    private String name;
}
