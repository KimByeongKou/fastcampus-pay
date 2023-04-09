package com.fastcampuspay.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataRechargeMoneyRepository extends JpaRepository<RechargeMoneyJpaEntity, Long> {
}
