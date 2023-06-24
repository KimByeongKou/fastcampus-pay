package com.fastcampuspay.remittance.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.remittance.adapter.out.persistence.RemittanceRequestMapper;
import com.fastcampuspay.remittance.application.port.in.RequestRemittanceCommand;
import com.fastcampuspay.remittance.application.port.in.RequestRemittanceUseCase;
import com.fastcampuspay.remittance.application.port.out.RequestRemittancePort;
import com.fastcampuspay.remittance.application.port.out.membership.MembershipPort;
import com.fastcampuspay.remittance.domain.RemittanceRequest;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestRemittanceService implements RequestRemittanceUseCase {

    private final RequestRemittancePort requestRemittancePort;
    private final RemittanceRequestMapper mapper;
    private final MembershipPort membershipPort;

    @Override
    public RemittanceRequest requestRemittance(RequestRemittanceCommand command) {

        membershipPort.getMembershipStatus(command.getMembershipId());

        return null;
    }
}
