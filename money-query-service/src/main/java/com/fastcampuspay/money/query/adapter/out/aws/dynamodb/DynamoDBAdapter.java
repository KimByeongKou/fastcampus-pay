package com.fastcampuspay.money.query.adapter.out.aws.dynamodb;

import com.fastcampuspay.money.query.application.port.out.GetMoneySumByRegionPort;
import com.fastcampuspay.money.query.application.port.out.MoneySum;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DynamoDBAdapter implements GetMoneySumByRegionPort {
    @Override
    public MoneySum getMoneySumByRegionPort(String regionName, Date startDate) {
        return null;
    }
}
