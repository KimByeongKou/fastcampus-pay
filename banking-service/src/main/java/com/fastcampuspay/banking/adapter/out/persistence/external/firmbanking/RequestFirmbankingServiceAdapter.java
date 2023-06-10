package com.fastcampuspay.banking.adapter.out.persistence.external.firmbanking;

import com.fastcampuspay.banking.application.port.out.GetExternalBankAccountInfoPort;
import com.fastcampuspay.banking.domain.BankAccount;
import com.fastcampuspay.common.ServiceAdapter;
import lombok.RequiredArgsConstructor;

@ServiceAdapter
@RequiredArgsConstructor
public class RequestFirmbankingServiceAdapter implements GetExternalBankAccountInfoPort {


    @Override
    public GetExternalBankAccountInfoResponse getExternalBankAccountInfo(BankAccount bankAccount) {
        return null;
    }
}
