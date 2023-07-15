package com.fastcampuspay.banking.adapter.axon.command;

import com.fastcampuspay.common.SelfValidating;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequestFirmbankingCommand  extends SelfValidating<CreateRequestFirmbankingCommand>  {
    private String fromBankName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private int moneyAmount;

}
