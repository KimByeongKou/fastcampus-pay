package com.fastcampuspay.settlement.adapter.out.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long paymentId;
    private String requestMembershipId;
    private int requestPrice;
    private String franchiseId;
    private String franchiseFeeRate;
    private int paymentStatus;
    private Date approvedAt;
}