package com.fastcampuspay.banking.adapter.out.external.bank;

import lombok.Data;

@Data
public class GetBankAccountRequest {
    private String bankName;
    private String bankAccountNumber;

    public GetBankAccountRequest(String bankName, String bankAccountNumber) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }
}
