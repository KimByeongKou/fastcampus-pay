package com.fastcampuspay.banking.application.service;

import com.fastcampuspay.banking.application.port.in.RegisterBankingAccountCommand;
import com.fastcampuspay.banking.application.port.in.RegisterBankingAccountUseCase;
import com.fastcampuspay.banking.application.port.out.RegisterBankingAccountPort;
import com.fastcampuspay.banking.domain.BankingAccountRegisterInfo;
import com.fastcampuspay.common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterBankingAccount implements RegisterBankingAccountUseCase {

	private final RegisterBankingAccountPort rport;

	@Override
	public void registerBankingAccount(RegisterBankingAccountCommand command) {
		rport.registerBankingAccount(new BankingAccountRegisterInfo.BankingAccountRegisterInfoId(command.getEmail()));
	}
}




