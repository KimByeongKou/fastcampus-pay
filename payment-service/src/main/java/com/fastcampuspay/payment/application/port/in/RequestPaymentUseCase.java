package com.fastcampuspay.payment.application.port.in;

import com.fastcampuspay.payment.domain.Payment;

public interface RequestPaymentUseCase {
    Payment requestPayment(RequestPaymentCommand command);
}
