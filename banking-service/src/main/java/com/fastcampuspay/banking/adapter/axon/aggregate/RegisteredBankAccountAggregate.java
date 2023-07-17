package com.fastcampuspay.banking.adapter.axon.aggregate;

import com.fastcampuspay.banking.adapter.axon.command.CreateRegisteredBankAccountCommand;
import com.fastcampuspay.banking.adapter.axon.event.CreateRegisteredBankAccountEvent;
import com.fastcampuspay.banking.adapter.out.external.bank.BankAccount;
import com.fastcampuspay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.common.command.CheckRegisteredBankAccountCommand;
import com.fastcampuspay.common.event.CheckedRegisteredBankAccountEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate()
public class RegisteredBankAccountAggregate {
    @AggregateIdentifier
    private String id;

    private String membershipId;

    private String bankName;

    private String bankAccountNumber;

    @CommandHandler
    public RegisteredBankAccountAggregate(@NotNull CreateRegisteredBankAccountCommand command) {
        System.out.println("CreateRegisteredBankAccountCommand Handler");

        // store event
        apply(new CreateRegisteredBankAccountEvent(command.getMembershipId(), command.getBankName(), command.getBankAccountNumber()));
    }

    @CommandHandler
    public void handle (@NotNull CheckRegisteredBankAccountCommand command, RequestBankAccountInfoPort bankAccountInfoPort) {
        System.out.println("CheckRegisteredBankAccountCommand Handler");
        id = command.getAggregateIdentifier();

        BankAccount bankAccount = bankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        String firmbankingUUID = UUID.randomUUID().toString();

        apply(new CheckedRegisteredBankAccountEvent(
                command.getRechargingRequestId()
                , command.getCheckRegisteredBankAccountId()
                , command.getMembershipId()
                , bankAccount.isValid()
                , command.getAmount()
                , firmbankingUUID
                , bankAccount.getBankName()
                , bankAccount.getBankAccountNumber()
            )
        );
    }

    @EventSourcingHandler
    public void on(CreateRegisteredBankAccountEvent event) {
        System.out.println("CreateRegisteredBankAccountEvent Sourcing Handler");
        id = UUID.randomUUID().toString();
        membershipId = event.getMembershipId();
        bankName = event.getBankName();
        bankAccountNumber = event.getBankAccountNumber();
    }

    public RegisteredBankAccountAggregate() {
        // System.out.println("RegisteredBankAccountAggregate Constructor");
    }
}
