package com.fastcampuspay.money.aggregation.application.port.in;

public interface GetMoneySumByAddressUseCase {
    int getMoneySumByAddress (GetMoneySumByAddressCommand command);
}
