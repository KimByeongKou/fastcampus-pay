package com.fastcampuspay.banking.application.port.out;


import com.fastcampuspay.banking.domain.BankingAccountRegisterInfo;

public interface RegisterBankingAccountPort {

	void registerBankingAccount(
			BankingAccountRegisterInfo.BankingAccountRegisterInfoId bankingAccountRegisterInfoId
	);
}
