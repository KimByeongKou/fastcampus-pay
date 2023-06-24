package com.fastcampuspay.remittance.application.port.out;

import com.fastcampuspay.remittance.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.fastcampuspay.remittance.application.port.in.FindRemittanceCommand;

import java.util.List;

public interface FindRemittancePort {

    List<RemittanceRequestJpaEntity> findRemittanceHistory(FindRemittanceCommand command);
}
