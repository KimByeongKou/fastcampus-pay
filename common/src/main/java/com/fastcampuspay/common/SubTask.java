package com.fastcampuspay.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubTask {
    private String membershipID;
    private String subTaskName;
    private String taskType; // "banking", "membership"
    private String status; // "success", "fail", "ready"
}
