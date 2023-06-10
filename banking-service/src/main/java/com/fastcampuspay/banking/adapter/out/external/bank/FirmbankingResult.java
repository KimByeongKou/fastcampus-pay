package com.fastcampuspay.banking.adapter.out.external.bank;

import lombok.Data;

@Data
public class FirmbankingResult {

    private int resultCode; // 0: 성공, 1: 실패


    public FirmbankingResult(int resultCode) {
        this.resultCode = resultCode;
    }
}
