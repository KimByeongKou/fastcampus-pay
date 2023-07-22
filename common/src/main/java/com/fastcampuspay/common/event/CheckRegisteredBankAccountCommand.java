package com.fastcampuspay.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckRegisteredBankAccountCommand {
    @TargetAggregateIdentifier
    private String aggregateIdentifier; // RegisteredBankAccount
    private String rechargeRequestId;
    private String membershipId;

    private String checkRegisteredBankAccountId;
    private String bankName;
    private String bankAccountNumber;
    private int amount;
}
