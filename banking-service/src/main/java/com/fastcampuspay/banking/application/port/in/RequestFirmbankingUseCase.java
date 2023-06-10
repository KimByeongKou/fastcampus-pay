package com.fastcampuspay.banking.application.port.in;


import com.fastcampuspay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
