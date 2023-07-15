package com.fastcampuspay.banking.adapter.axon.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRequestFirmbankingEvent {

    private int firmbankingStatus;
}
