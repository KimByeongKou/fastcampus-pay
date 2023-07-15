package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.banking.adapter.axon.command.UpdateRequestFirmbankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmbankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmbankingUseCase;
import com.fastcampuspay.banking.domain.FirmbankingRequest;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmbankingController {
    private final RequestFirmbankingUseCase requestFirmbankingUseCase;
    @PostMapping(path = "/banking/firmbanking/request")
    FirmbankingRequest requestFirmbanking(@RequestBody RequestFirmbankingRequest request) {
        RequestFirmbankingCommand command = RequestFirmbankingCommand.builder()
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        return requestFirmbankingUseCase.requestFirmbanking(command);
    }

    @PostMapping(path = "/banking/firmbanking/request-eda")
    void requestFirmbankingByEvent(@RequestBody RequestFirmbankingRequest request) {
        RequestFirmbankingCommand command = RequestFirmbankingCommand.builder()
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        requestFirmbankingUseCase.requestFirmbankingByEvent(command);
    }

    @PostMapping(path = "/banking/firmbanking/update-eda")
    void updateFirmbankingByEvent(@RequestBody UpdateFirmbankingRequest request) {
        UpdateRequestFirmbankingCommand command =UpdateRequestFirmbankingCommand.builder().aggregateIdentifier(request.getFirmbankingAggregateIdentifier()).firmbankingStatus(request.getStatus()).build();
        requestFirmbankingUseCase.updateFirmbankingByEvent(command);
    }
}
