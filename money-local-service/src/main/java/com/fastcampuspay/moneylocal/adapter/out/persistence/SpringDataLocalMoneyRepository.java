package com.fastcampuspay.moneylocal.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataLocalMoneyRepository extends JpaRepository<LocalMoneyJpaEntity, Long> {
}
