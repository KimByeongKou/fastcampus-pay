package com.fastcampuspay.banking.application.port.in;


import com.fastcampuspay.banking.adapter.axon.command.UpdateRequestFirmbankingCommand;
import com.fastcampuspay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
    void requestFirmbankingByEvent(RequestFirmbankingCommand command);
    void updateFirmbankingByEvent(UpdateRequestFirmbankingCommand command);
}
