package com.fastcampuspay.money.query.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.money.query.adapter.axon.QueryMoneySumByAddress;
import com.fastcampuspay.money.query.application.port.in.QueryMoneySumByRegionQuery;
import com.fastcampuspay.money.query.application.port.in.QueryMoneySumByRegionUseCase;
import com.fastcampuspay.money.query.domain.MoneySumByRegion;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.ExecutionException;

@UseCase
@RequiredArgsConstructor
@Transactional
public class QueryMoneySumByRegionService implements QueryMoneySumByRegionUseCase {
    private final QueryGateway queryGateway;
    @Override
    public MoneySumByRegion queryMoneySumByRegion(QueryMoneySumByRegionQuery query) {
        try {
            return queryGateway.query(new QueryMoneySumByAddress(query.getAddress())
                    , MoneySumByRegion.class).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
