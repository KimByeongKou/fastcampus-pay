package com.fastcampuspay.settlement.tasklet;

import com.fastcampuspay.settlement.adapter.out.service.Payment;
import com.fastcampuspay.settlement.port.out.GetRegisteredBankAccountPort;
import com.fastcampuspay.settlement.port.out.PaymentPort;
import com.fastcampuspay.settlement.port.out.RegisteredBankAccountAggregateIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirmbankingRequestInfo {

    private String bankName;
    private String bankAccountNumber;
    private int moneyAmount;

    public FirmbankingRequestInfo(String bankName, String bankAccountNumber) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }
}