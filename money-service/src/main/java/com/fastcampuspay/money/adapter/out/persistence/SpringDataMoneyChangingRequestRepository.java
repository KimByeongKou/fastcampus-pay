package com.fastcampuspay.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMoneyChangingRequestRepository extends JpaRepository<MoneyChangingRequestJpaEntity, Long> {
}
