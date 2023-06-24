package com.fastcampuspay.remittance.application.port.out;

import com.fastcampuspay.remittance.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.fastcampuspay.remittance.application.port.in.RequestRemittanceCommand;

public interface RequestRemittancePort {

    RemittanceRequestJpaEntity createRemittanceRequestHistory(RequestRemittanceCommand command);
    boolean saveRemittanceRequestHistory(RemittanceRequestJpaEntity entity);
}
