package com.fastcampuspay.membership.application.saga;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderConfirmedEvent  {
    private String orderId;

}
