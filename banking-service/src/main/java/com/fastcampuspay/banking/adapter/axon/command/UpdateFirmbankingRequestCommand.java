package com.fastcampuspay.banking.adapter.axon.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateFirmbankingRequestCommand {

    @NotNull
    @TargetAggregateIdentifier
    private String aggregateIdentifier;

    private int firmbankingStatus;

}
