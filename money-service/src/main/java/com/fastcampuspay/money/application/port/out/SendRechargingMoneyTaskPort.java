package com.fastcampuspay.money.application.port.out;

import com.fastcampuspay.money.adapter.out.kafka.RechargingMoneyTask;

public interface SendRechargingMoneyTaskPort {
    void sendRechargingMoneyTaskPort(
            RechargingMoneyTask task
    );
}
