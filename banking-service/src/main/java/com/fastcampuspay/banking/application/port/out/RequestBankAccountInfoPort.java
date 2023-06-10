package com.fastcampuspay.banking.application.port.out;

import com.fastcampuspay.banking.adapter.out.external.bank.BankAccount;
import com.fastcampuspay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request) ;
}
