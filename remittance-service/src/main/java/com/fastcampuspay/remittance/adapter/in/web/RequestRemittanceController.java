package com.fastcampuspay.remittance.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.remittance.application.port.in.RequestRemittanceCommand;
import com.fastcampuspay.remittance.application.port.in.RequestRemittanceUseCase;
import com.fastcampuspay.remittance.domain.RemittanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestRemittanceController {

    private final RequestRemittanceUseCase requestRemittanceUseCase;
    @PostMapping(path = "/remittance/request")
    RemittanceRequest requestRemittance(@RequestBody RequestRemittanceRequest request) {
        RequestRemittanceCommand command = RequestRemittanceCommand.builder()
                .fromMembershipId(request.getFromMembershipId())
                .toMembershipId(request.getToMembershipId())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .amount(request.getAmount())
                .remittanceType(request.getRemittanceType())
                .build();

        return requestRemittanceUseCase.requestRemittance(command);
    }
}
