package com.fastcampuspay.remittance.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.remittance.application.port.out.RemittancePort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RemittancePersistenceAdapter implements RemittancePort {

    private final SpringDataRemittanceRepository remittanceRepository;

    @Override
    public RemittanceJpaEntity createRemittance() {
        return null;
    }
}
