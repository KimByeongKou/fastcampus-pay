package com.fastcampuspay.money.query.application.port.out;

import java.util.Date;

public interface InsertMoneyIncreaseEventByAddress {
    void insertMoneyIncreaseEventByAddress(String addressName, int moneyIncrease);
}
