package com.fastcampuspay.money.adapter.axon.command;

import com.fastcampuspay.money.adapter.axon.event.RechargingRequestCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Component
public class RechargingMoneyCommandHandler {
    private final CommandGateway commandGateway;

    public RechargingMoneyCommandHandler(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


}
