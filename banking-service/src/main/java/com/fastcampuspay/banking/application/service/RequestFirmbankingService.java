package com.fastcampuspay.banking.application.service;

import com.fastcampuspay.banking.adapter.axon.command.CreateRequestFirmbankingCommand;
import com.fastcampuspay.banking.adapter.axon.command.UpdateRequestFirmbankingCommand;
import com.fastcampuspay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.fastcampuspay.banking.adapter.out.external.bank.FirmbankingResult;
import com.fastcampuspay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.FirmbankingRequestMapper;
import com.fastcampuspay.banking.application.port.in.RequestFirmbankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmbankingUseCase;
import com.fastcampuspay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.fastcampuspay.banking.application.port.out.RequestFirmbankingPort;
import com.fastcampuspay.banking.domain.FirmbankingRequest;
import com.fastcampuspay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;

import javax.transaction.Transactional;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {
    private final FirmbankingRequestMapper mapper;
    private final RequestFirmbankingPort requestFirmbankingPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    private final CommandGateway commandGateway;

    @Override
    public FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command) {

        // Business Logic
        // a -> b 계좌

        // 1. 요청에 대해 정보를 먼저 write . "요청" 상태로
        FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
                new FirmbankingRequest.FromBankName(command.getFromBankName()),
                new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmbankingRequest.ToBankName(command.getToBankName()),
                new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmbankingRequest.FirmbankingStatus(0),
                new FirmbankingRequest.FirmbankingAggregateIdentifier("")
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber()
        ));

        // Transactional UUID
        UUID randomUUID = UUID.randomUUID();
        requestedEntity.setUuid(randomUUID.toString());

        // 3. 결과에 따라서 1번에서 작성했던 FirmbankingRequest 정보를 Update
        if (result.getResultCode() == 0){
            // 성공
            requestedEntity.setFirmbankingStatus(1);
        } else {
            // 실패
            requestedEntity.setFirmbankingStatus(2);
        }

        // 4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
        return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity), randomUUID);
    }

    @Override
    public void requestFirmbankingByEvent(RequestFirmbankingCommand command) {

        commandGateway.send(new CreateRequestFirmbankingCommand(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber(),
                command.getMoneyAmount()
        )).whenComplete((result, throwable) -> {
            if (throwable == null) {
                System.out.println("RequestFirmbankingCommand Aggregate ID:" + result.toString());

                FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
                        new FirmbankingRequest.FromBankName(command.getFromBankName()),
                        new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                        new FirmbankingRequest.ToBankName(command.getToBankName()),
                        new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                        new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
                        new FirmbankingRequest.FirmbankingStatus(0),
                        new FirmbankingRequest.FirmbankingAggregateIdentifier(result.toString())
                );

                // 2. 외부 은행에 펌뱅킹 요청
                FirmbankingResult firmbankingResult = requestExternalFirmbankingPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
                        command.getFromBankName(),
                        command.getFromBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber()
                ));

                // Transactional UUID
                UUID randomUUID = UUID.randomUUID();
                requestedEntity.setUuid(randomUUID.toString());

                // 3. 결과에 따라서 1번에서 작성했던 FirmbankingRequest 정보를 Update
                if (firmbankingResult.getResultCode() == 0){
                    // 성공
                    requestedEntity.setFirmbankingStatus(1);
                } else {
                    // 실패
                    requestedEntity.setFirmbankingStatus(2);
                }

            } else {
                throwable.printStackTrace();
                System.out.println("error : " + throwable.getMessage());
            }
        });

        // Business Logic
        // a -> b 계좌
    }

    @Override
    public void updateFirmbankingByEvent(UpdateRequestFirmbankingCommand command) {
        commandGateway.send(command)
                .whenComplete((result, throwable) -> {
            if (throwable == null) {
                System.out.println("updateFirmbankingByEvent Aggregate ID:" + result.toString());
                FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.getFirmbankingRequest(
                        new FirmbankingRequest.FirmbankingAggregateIdentifier(result.toString())
                );

                // 2. 외부 은행에 펌뱅킹 요청
//                FirmbankingResult firmbankingResult = requestExternalFirmbankingPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
//                        command.getFromBankName(),
//                        command.getFromBankAccountNumber(),
//                        command.getToBankName(),
//                        command.getToBankAccountNumber()
//                ));
                requestedEntity.setFirmbankingStatus(command.getFirmbankingStatus());
                requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity);
            } else {
                System.out.println("error : " + throwable.getMessage());
                throwable.printStackTrace();
            }
        });
    }
}
