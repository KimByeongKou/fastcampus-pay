package com.fastcampuspay.money.application.port.out;

import com.fastcampuspay.common.RechargingMoneyTask;

public interface SendRechargingMoneyTaskPort {
    void sendRechargingMoneyTaskPort(
            RechargingMoneyTask task
    );
}
