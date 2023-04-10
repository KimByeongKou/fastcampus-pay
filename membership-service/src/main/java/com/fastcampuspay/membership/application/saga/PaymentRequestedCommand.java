package com.fastcampuspay.membership.application.saga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentRequestedCommand {
    private String paymentId;
    private String orderId;
    private double amount;
    // getters and setters
}
