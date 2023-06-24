package com.fastcampuspay.remittance.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RemittanceRequest {
    @Getter private final String remittanceRequestId;

    @Value
    public static class RemittanceRequestId {
        public RemittanceRequestId(String value) {
            this.remittanceRequestId = value;
        }
        String remittanceRequestId ;
    }

    public static RemittanceRequest generateRemittanceRequest(
    ){
        return new RemittanceRequest(
                ""
        );
    }
}
