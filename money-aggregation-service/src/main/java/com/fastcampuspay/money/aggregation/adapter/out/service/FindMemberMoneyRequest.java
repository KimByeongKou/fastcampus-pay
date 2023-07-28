package com.fastcampuspay.money.aggregation.adapter.out.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMemberMoneyRequest {
    private List<String> membershipIds;
}
