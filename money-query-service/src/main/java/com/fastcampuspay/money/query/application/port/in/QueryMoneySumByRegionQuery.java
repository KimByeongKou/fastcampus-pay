package com.fastcampuspay.money.query.application.port.in;

import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class QueryMoneySumByRegionQuery extends SelfValidating<QueryMoneySumByRegionQuery> {
    private final String address;
}
