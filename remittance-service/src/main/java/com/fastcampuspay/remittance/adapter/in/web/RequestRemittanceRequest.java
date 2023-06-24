package com.fastcampuspay.remittance.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRemittanceRequest {
    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
