package com.fastcampuspay.remittance.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRemittanceRequest {

    // 송금 요청을 위한 정보가 담긴 class

    private String fromMembershipId; // from membership
    private String toMembershipId; // to membership

    private String toBankName;
    private String toBankAccountNumber;

    private int remittanceType; // 0: membership(내부 고객), 1: bank (외부 은행 계좌)
    // 송금요청 금액
    private int amount;
}
