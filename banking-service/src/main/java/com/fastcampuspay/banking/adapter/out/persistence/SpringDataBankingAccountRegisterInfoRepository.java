package com.fastcampuspay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataBankingAccountRegisterInfoRepository extends JpaRepository<BankingAccountRegisterInfoJpaEntity, Long> {
}
