package com.fastcampuspay.settlement.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataSettlementRepository extends JpaRepository<SettlementJpaEntity, Long> {
}
