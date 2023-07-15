package com.fastcampuspay.money.adapter.axon.saga;

import com.fastcampuspay.common.event.CheckRegisteredBankAccountCommand;
import com.fastcampuspay.common.event.CheckedRegisteredBankAccountEvent;
import com.fastcampuspay.money.adapter.axon.event.RechargingRequestCreatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
@Getter
@NoArgsConstructor
public class MoneyRechargeSaga {
    @NonNull
    private transient CommandGateway commandGateway;


    @Autowired
    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @StartSaga
    @SagaEventHandler(associationProperty = "rechargingRequestId")
    public void handle(RechargingRequestCreatedEvent event) {
        System.out.println("RechargingRequestCreatedEvent Start saga");
        String rechargingRequestId = event.getRechargingRequestId();
        SagaLifecycle.associateWith("rechargingRequestId", rechargingRequestId);

        // "충전 요청" 시작.
        // 뱅킹의 계좌 등록 여부 확인하기.


        // 뱅킹의 id 를 알아야 하는디 ,,?
        // 1. 뱅킹 서비스에 정상 계좌 연결 되어있는지 확인.
            // 1-1. 연결되어있지 않으면, "충전 요청" 실패 상태로 변경.
        commandGateway.send(new CheckRegisteredBankAccountCommand("", rechargingRequestId, event.getMembershipId()));
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "rechargingRequestId")
    public void handle(CheckedRegisteredBankAccountEvent event) {
        System.out.println("CheckedRegisteredBankAccountEvent End saga");
        String rechargingRequestId = event.getRechargingRequestId();


        // 2. 펌뱅킹을 통한 송금 요청 (고객 계좌 -> 패캠 계좌). 성공 상태.

        // 3. 머니 서비스에서 고객 머니 증액
        // 3-1. 증액 실패 시. -> 아까의 펌뱅킹 상태 롤백 요청.
    }

}
