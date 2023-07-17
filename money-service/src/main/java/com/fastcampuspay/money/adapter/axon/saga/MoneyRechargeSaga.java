package com.fastcampuspay.money.adapter.axon.saga;

import com.fastcampuspay.common.command.CheckRegisteredBankAccountCommand;
import com.fastcampuspay.common.command.RequestFirmbankingCommand;
import com.fastcampuspay.common.command.RollbackFirmbankingRequestCommand;
import com.fastcampuspay.common.event.CheckedRegisteredBankAccountEvent;
import com.fastcampuspay.common.event.RequestFirmbankingFinishedEvent;
import com.fastcampuspay.common.event.RollbackFirmbankingFinishedEvent;
import com.fastcampuspay.money.adapter.axon.event.RechargingRequestCreatedEvent;
import com.fastcampuspay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.fastcampuspay.money.application.port.out.IncreaseMoneyPort;
import com.fastcampuspay.money.domain.MemberMoney;
import lombok.NonNull;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.UUID;

@Saga
public class MoneyRechargeSaga {
    private transient CommandGateway commandGateway;

    @Autowired
    public void setCommandGateway(@NotNull CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @StartSaga
    @SagaEventHandler(associationProperty = "rechargingRequestId")
    public void handle(RechargingRequestCreatedEvent event) {
        System.out.println("RechargingRequestCreatedEvent Start saga recharging request event  : " + event.toString());

        String checkRegisteredBankAccountId = UUID.randomUUID().toString();
        SagaLifecycle.associateWith("checkRegisteredBankAccountId", checkRegisteredBankAccountId);

        commandGateway.send(new CheckRegisteredBankAccountCommand(
                event.getBankingAccountAggregateIdentifier()
                , event.toString()
                , checkRegisteredBankAccountId
                , event.getMembershipId()
                , event.getBankName()
                , event.getBankAccountNumber()
                , event.getAmount()
        )).whenComplete(
                (result, throwable) -> {
                    if (throwable != null) {
                        throwable.printStackTrace();
                        System.out.println("CheckRegisteredBankAccountCommand Command failed");
                    } else {
                        System.out.println("CheckRegisteredBankAccountCommand Command success");
                    }
                }
        );
    }

    @SagaEventHandler(associationProperty = "checkRegisteredBankAccountId")
    public void handle(CheckedRegisteredBankAccountEvent event) {
        System.out.println("CheckedRegisteredBankAccountEvent saga: " + event.toString());
        boolean status = event.isChecked();
        if (status) {
            System.out.println("CheckedRegisteredBankAccountEvent event success");
        } else {
            System.out.println("CheckedRegisteredBankAccountEvent event Failed");
        }

        String requestFirmbankingId = UUID.randomUUID().toString();
        SagaLifecycle.associateWith("requestFirmbankingId", requestFirmbankingId);

        // 2. 송금 요청
        commandGateway.send(new RequestFirmbankingCommand(
                requestFirmbankingId,
                event.getFirmbankingRequestAggregateIdentifier()
                , event.getRechargingRequestId()
                , event.getMembershipId()
                , "fastcampus"
                , "123456789"
                , event.getToBankName()
                , event.getToBankAccountNumber()
                , event.getAmount()
        )).whenComplete(
                (result, throwable) -> {
                    if (throwable != null) {
                        throwable.printStackTrace();
                        System.out.println("RequestFirmbankingCommand Command failed");
                    } else {
                        System.out.println("RequestFirmbankingCommand Command success");
                    }
                }
        );
    }

    @SagaEventHandler(associationProperty = "requestFirmbankingId")
    public void handle(RequestFirmbankingFinishedEvent event, IncreaseMoneyPort increaseMoneyPort) {
        System.out.println("RequestFirmbankingFinishedEvent saga: " + event.toString());
        boolean status = event.getStatus() == 0;
        if (status) {
            System.out.println("RequestFirmbankingFinishedEvent event success");
        } else {
            System.out.println("RequestFirmbankingFinishedEvent event Failed");
        }

        // DB Update 명령.
        MemberMoneyJpaEntity resultEntity =
                increaseMoneyPort.increaseMoney(
                new MemberMoney.MembershipId(event.getMembershipId())
                , event.getMoneyAmount()
        );

        if (resultEntity == null) {
            // 실패 시, 롤백 이벤트
            String rollbackFirmbankingId = UUID.randomUUID().toString();
            SagaLifecycle.associateWith("rollbackFirmbankingId", rollbackFirmbankingId);
            commandGateway.send(new RollbackFirmbankingRequestCommand(
                    rollbackFirmbankingId
                    ,event.getRequestFirmbankingAggregateIdentifier()
                    , event.getRechargingRequestId()
                    , event.getMembershipId()
                    , event.getToBankName()
                    , event.getToBankAccountNumber()
                    , event.getMoneyAmount()
            )).whenComplete(
                    (result, throwable) -> {
                        if (throwable != null) {
                            throwable.printStackTrace();
                            System.out.println("RollbackFirmbankingRequestCommand Command failed");
                        } else {
                            System.out.println("Saga success : "+ result.toString());
                            SagaLifecycle.end();
                        }
                    }
            );
        } else {
            // 성공 시, saga 종료.
            SagaLifecycle.end();
        }
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "rollbackFirmbankingId")
    public void handle(RollbackFirmbankingFinishedEvent event) {
        System.out.println("RollbackFirmbankingFinishedEvent saga: " + event.toString());
    }
}
