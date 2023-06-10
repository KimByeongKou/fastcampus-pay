package com.fastcampuspay.banking.application.port.in;


import com.fastcampuspay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {
    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
