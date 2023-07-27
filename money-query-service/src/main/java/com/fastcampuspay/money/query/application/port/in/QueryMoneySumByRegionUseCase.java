package com.fastcampuspay.money.query.application.port.in;

import com.fastcampuspay.money.query.domain.MoneySumByRegion;

public interface QueryMoneySumByRegionUseCase {

    MoneySumByRegion queryMoneySumByRegion (QueryMoneySumByRegionQuery query);
}
