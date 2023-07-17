package com.fastcampuspay.money.adapter.axon.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargingRequestCreatedEvent {
    private String rechargingRequestId;

    private String membershipId;

    private int amount;

    private String bankingAccountAggregateIdentifier;

    private String bankName;
    private String bankAccountNumber;

    @Override
    public String toString() {
        return "RechargingRequestCreatedEvent{" +
                "rechargingRequestId='" + rechargingRequestId + '\'' +
                ", membershipId='" + membershipId + '\'' +
                ", amount=" + amount +
                ", bankingAccountAggregateIdentifier='" + bankingAccountAggregateIdentifier + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }
}
