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
    private final String aggregateIdentifier;

    @NotNull
    private final String targetMembershipId;

    @NotNull
    private final int amount;

    public IncreaseMoneyEvent(String aggregateIdentifier, String targetMembershipId, int amount) {
        this.aggregateIdentifier = aggregateIdentifier;
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;
    }
}
