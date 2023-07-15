package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.application.port.out.RequestFirmbankingPort;
import com.fastcampuspay.banking.domain.FirmbankingRequest;
import com.fastcampuspay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;


    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(FirmbankingRequest.FromBankName fromBankName, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmbankingRequest.ToBankName toBankName, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber, FirmbankingRequest.MoneyAmount moneyAmount, FirmbankingRequest.FirmbankingStatus firmbankingStatus, FirmbankingRequest.FirmbankingAggregateIdentifier firmbankingAggregateIdentifier) {
        return firmbankingRequestRepository.save(new FirmbankingRequestJpaEntity(
                        fromBankName.getFromBankName(),
                        fromBankAccountNumber.getFromBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        moneyAmount.getMoneyAmount(), firmbankingStatus.getFirmBankingStatus(),
                        UUID.randomUUID(),
                        firmbankingAggregateIdentifier.getAggregateIdentifier()
                )
        );
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }

    @Override
    public FirmbankingRequestJpaEntity getFirmbankingRequest(FirmbankingRequest.FirmbankingAggregateIdentifier firmbankingAggregateIdentifier) {
        List<FirmbankingRequestJpaEntity> entityList =  firmbankingRequestRepository.findByAggregateIdentifier(firmbankingAggregateIdentifier.getAggregateIdentifier());
        if(entityList.size() > 0) {
            return entityList.get(0);
        }
        return null;
    }
}
