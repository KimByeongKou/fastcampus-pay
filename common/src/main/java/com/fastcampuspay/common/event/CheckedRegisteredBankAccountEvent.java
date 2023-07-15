package com.fastcampuspay.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckedRegisteredBankAccountEvent {
    private String rechargingRequestId;
    private String membershipId;
    private boolean status;
}
