package com.fastcampuspay.remittance.application.port.out;

import com.fastcampuspay.remittance.adapter.out.persistence.RemittanceRequestJpaEntity;

public interface RequestRemittancePort {

    RemittanceRequestJpaEntity createRemittanceRequestHistory(
    );
}
