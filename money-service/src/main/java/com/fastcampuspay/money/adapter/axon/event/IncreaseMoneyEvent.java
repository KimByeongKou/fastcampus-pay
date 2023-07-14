package com.fastcampuspay.money.adapter.axon.event;

import com.fastcampuspay.common.SelfValidating;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestCommand;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class IncreaseMoneyEvent extends SelfValidating<IncreaseMoneyRequestCommand>  {

    @NotNull
    private final String targetMembershipId;

    @NotNull
    private final int amount;


    public IncreaseMoneyEvent(@NotNull String targetMembershipId, @NotNull int amount) {
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;
        this.validateSelf();
    }
}
