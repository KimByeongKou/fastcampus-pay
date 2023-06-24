package com.fastcampuspay.remittance.adapter.out.persistence;

import com.fastcampuspay.remittance.domain.RemittanceRequest;
import org.springframework.stereotype.Component;

@Component
public class RemittanceRequestMapper {
    public RemittanceRequest mapToDomainEntity(RemittanceRequestJpaEntity remittanceRequestJpaEntity) {
        return RemittanceRequest.generateRemittanceRequest(
            new RemittanceRequest.RemittanceRequestId(remittanceRequestJpaEntity.getFromMembershipId()),
                new RemittanceRequest.RemittanceFromMembershipId(remittanceRequestJpaEntity.getFromMembershipId()),
                new RemittanceRequest.ToBankName(remittanceRequestJpaEntity.getToBankName()),
                new RemittanceRequest.ToBankAccountNumber(remittanceRequestJpaEntity.getToBankAccountNumber()),
                new RemittanceRequest.RemittanceType(remittanceRequestJpaEntity.getRemittanceType()),
                new RemittanceRequest.Amount(remittanceRequestJpaEntity.getAmount()),
                new RemittanceRequest.RemittanceStatus(remittanceRequestJpaEntity.getRemittanceStatus())
        );
    }
}
