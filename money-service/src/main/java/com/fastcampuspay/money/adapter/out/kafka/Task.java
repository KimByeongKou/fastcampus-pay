package com.fastcampuspay.money.adapter.out.kafka;

import lombok.Data;

@Data
public abstract class Task {
    private String taskID;
    private String taskName;
}
