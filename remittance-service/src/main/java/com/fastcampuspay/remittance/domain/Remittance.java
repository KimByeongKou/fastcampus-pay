package com.fastcampuspay.remittance.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Remittance {
    @Getter
    private final String remittanceId;

    @Value
    public static class RemittanceId {
        public RemittanceId(String value) {
            this.remittanceId = value;
        }

        String remittanceId;
    }

    public static Remittance generateRemittance(
    ){
        return new Remittance(
                ""
        );
    }
}
