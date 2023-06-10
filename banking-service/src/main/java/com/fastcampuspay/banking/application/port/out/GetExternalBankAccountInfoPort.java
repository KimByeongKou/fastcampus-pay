package com.fastcampuspay.banking.application.port.out;

import com.fastcampuspay.banking.adapter.out.persistence.external.firmbanking.GetExternalBankAccountInfoResponse;
import com.fastcampuspay.banking.domain.BankAccount;

public interface GetExternalBankAccountInfoPort {


    GetExternalBankAccountInfoResponse getExternalBankAccountInfo (BankAccount bankAccount);
}
