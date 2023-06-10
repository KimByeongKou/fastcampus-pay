package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.domain.FirmbankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FirmbankingRequestMapper {
    public FirmbankingRequest mapToDomainEntity(FirmbankingRequestJpaEntity registeredBankAccountJpaEntity, UUID uuid) {
        return FirmbankingRequest.generateFirmbankingRequest(
                new FirmbankingRequest.FirmbankingRequestId(registeredBankAccountJpaEntity.getRequestFirmbankingId()+""),
                new FirmbankingRequest.FromBankName(registeredBankAccountJpaEntity.getFromBankName()),
                new FirmbankingRequest.FromBankAccountNumber(registeredBankAccountJpaEntity.getFromBankAccountNumber()),
                new FirmbankingRequest.ToBankName(registeredBankAccountJpaEntity.getToBankName()),
                new FirmbankingRequest.ToBankAccountNumber(registeredBankAccountJpaEntity.getToBankAccountNumber()),
                new FirmbankingRequest.MoneyAmount(registeredBankAccountJpaEntity.getMoneyAmount()),
                new FirmbankingRequest.FirmbankingStatus(registeredBankAccountJpaEntity.getFirmbankingStatus()),
                uuid
        );
    }
}
