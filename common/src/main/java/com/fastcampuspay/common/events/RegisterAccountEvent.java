package com.fastcampuspay.common.events;

import java.util.Objects;

public class RegisterAccountEvent {
    private final String accountId;

    public RegisterAccountEvent(){
        this.accountId = "0000";
    }
    public RegisterAccountEvent(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegisterAccountEvent that = (RegisterAccountEvent) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public String toString() {
        return "OrderCreatedEvent{" + "orderId='" + accountId + '\'' + '}';
    }


}
