package com.fastcampuspay.money.adapter.out.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RechargingMoneyTask extends Task { // Increase Money

    private String membershipID;

    private List<SubTask> subTaskList;

    // 법인 계좌
    private String toBankName;

    // 법인 계좌 번호
    private String toBankAccountNumber;

    private int moneyAmount; // only won
}
