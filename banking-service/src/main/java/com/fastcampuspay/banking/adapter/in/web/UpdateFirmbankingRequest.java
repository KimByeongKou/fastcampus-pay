package com.fastcampuspay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFirmbankingRequest {
    private String firmbankingRequestAggregateIdentifier;
    private int status;

    // TODO: Add a field for the reason of the status change.
}
