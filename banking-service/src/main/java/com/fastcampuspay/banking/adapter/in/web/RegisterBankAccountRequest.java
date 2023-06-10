package com.fastcampuspay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {
    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
