package com.fastcampuspay.money.adapter.out.kafka;

public class SubTask {
    private String membershipID;
    private String subTaskID;
    private String subTaskName;
    private String statusType; // "banking", "membership"
    private String status; // "success", "fail"
}
