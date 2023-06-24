package com.fastcampuspay.remittance.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.remittance.application.port.out.RequestRemittancePort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RemittanceRequestPersistenceAdapter implements RequestRemittancePort {

    private final SpringDataRemittanceRequestRepository remittanceRequestRepository;

    @Override
    public RemittanceRequestJpaEntity createRemittanceRequestHistory() {
        return null;
    }
}
