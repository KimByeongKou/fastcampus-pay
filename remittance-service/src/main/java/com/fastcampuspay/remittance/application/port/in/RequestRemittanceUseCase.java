package com.fastcampuspay.remittance.application.port.in;


import com.fastcampuspay.remittance.domain.RemittanceRequest;

public interface RequestRemittanceUseCase {
    RemittanceRequest requestRemittance(RequestRemittanceCommand command);
}
