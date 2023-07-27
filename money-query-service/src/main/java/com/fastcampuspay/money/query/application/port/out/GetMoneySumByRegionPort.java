package com.fastcampuspay.money.query.application.port.out;

import java.util.Date;

public interface GetMoneySumByRegionPort {
    MoneySum getMoneySumByRegionPort(String regionName, Date startDate);
}
