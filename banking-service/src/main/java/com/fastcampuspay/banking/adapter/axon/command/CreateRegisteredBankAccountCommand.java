package com.fastcampuspay.banking.adapter.axon.command;

import com.fastcampuspay.common.SelfValidating;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CreateRegisteredBankAccountCommand extends SelfValidating<CreateRegisteredBankAccountCommand>  {
    private String membershipId;

    private String bankName;
    private String bankAccountNumber;

}
