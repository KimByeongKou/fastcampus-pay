package com.fastcampuspay.remittance.application.port.out;

import com.fastcampuspay.remittance.adapter.out.persistence.RemittanceJpaEntity;

public interface RemittancePort {

    RemittanceJpaEntity createRemittance();
}
