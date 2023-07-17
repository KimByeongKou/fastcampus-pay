package com.fastcampuspay.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RollbackFirmbankingFinishedEvent {
    private String rollbackFirmbankingId;
    private String membershipId;
    private String rollbackFirmbankingAggregateIdentifier;
}
