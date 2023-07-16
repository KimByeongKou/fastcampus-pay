package com.fastcampuspay.banking.adapter.axon.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FirmbankingRequestCreatedEvent {

    private String fromBankName;
    private String fromBankAccountNumber;

    private String toBankName;
    private String toBankAccountNumber;

    private int moneyAmount;
}
