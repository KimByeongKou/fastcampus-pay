package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.application.port.out.RegisterBankingAccountPort;
import com.fastcampuspay.banking.domain.BankingAccountRegisterInfo;
import com.fastcampuspay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class BankingAccountPersistenceAdapter implements RegisterBankingAccountPort {

	private final SpringDataBankingAccountRegisterInfoRepository bankingAccountRepository;
	 private final BankingAccountRegisterInfoMapper bankingAccountRegisterInfoMapper;

	private Long orZero(Long value){
		return value == null ? 0L : value;
	}


	@Override
	public void registerBankingAccount(BankingAccountRegisterInfo.BankingAccountRegisterInfoId bankingAccountRegisterInfoId) {
		bankingAccountRepository.save(
				new BankingAccountRegisterInfoJpaEntity(
						Long.parseLong(bankingAccountRegisterInfoId.getBankingAccountRegisterInfoId())
				)
		);
	}
}
