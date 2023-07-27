package com.fastcampuspay.money.query.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class MoneyQueryController {

    // private final RegisterBankAccountUseCase registeredBankAccountUseCase;
    @GetMapping(path = "/money/query/get-money-sum-by-address/{address}")
    int getMoneySumByAddress(@PathVariable String address) {
//        FindRemittanceCommand command = FindRemittanceCommand.builder()
//                .membershipId(membershipId)
//                .build();

        return 1000;
    }
}
