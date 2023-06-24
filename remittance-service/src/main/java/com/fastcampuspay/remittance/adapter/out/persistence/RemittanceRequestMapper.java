package com.fastcampuspay.remittance.adapter.out.persistence;

import com.fastcampuspay.remittance.domain.RemittanceRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RemittanceRequestMapper {
    public RemittanceRequest mapToDomainEntity(RemittanceRequestJpaEntity remittanceRequestJpaEntity, UUID uuid) {
        return RemittanceRequest.generateRemittanceRequest(

        );
    }
}
