package com.fastcampuspay.banking.adapter.axon.command;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateFirmbankingRequestCommand {

    private String fromBankName;
    private String fromBankAccountNumber;

    private String toBankName;
    private String toBankAccountNumber;

    private int moneyAmount;
}
