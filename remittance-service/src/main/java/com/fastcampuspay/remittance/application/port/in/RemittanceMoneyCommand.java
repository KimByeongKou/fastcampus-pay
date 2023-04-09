package com.fastcampuspay.remittance.application.port.in;


import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
@EqualsAndHashCode(callSuper = false)
public
class RemittanceMoneyCommand extends SelfValidating<RemittanceMoneyCommand> {

    @NotNull
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    private final String address;

    @NotNull
    private final boolean isValid;

    public RemittanceMoneyCommand(String name, String email, String address, boolean isValid) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
    }
}
