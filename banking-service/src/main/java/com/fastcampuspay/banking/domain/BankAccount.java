package com.fastcampuspay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccount {
    @Getter private final String bankAccountId;

    public static BankAccount generateBankAccount (
            BankAccountId bankAccountId

    ){
        return new BankAccount(
                bankAccountId.bankAccountId

        );
    }

    @Value
    public static class BankAccountId {
        public BankAccountId(String value) {
            this.bankAccountId = value;
        }
        String bankAccountId ;
    }

}
