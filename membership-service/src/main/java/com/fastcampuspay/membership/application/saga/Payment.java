package com.fastcampuspay.membership.application.saga;

import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Data
@Aggregate()
public class Payment {
    private String orderId;


    @AggregateIdentifier
    private String paymentId;

    // getters and setters
}
