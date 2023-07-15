package com.fastcampuspay.banking.adapter.axon.command;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateRequestFirmbankingCommand {
    @NotNull
    @TargetAggregateIdentifier
    private String aggregateIdentifier;

    private final int firmbankingStatus;
}
