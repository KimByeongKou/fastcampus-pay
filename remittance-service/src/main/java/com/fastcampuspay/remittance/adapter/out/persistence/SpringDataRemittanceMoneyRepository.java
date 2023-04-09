package com.fastcampuspay.remittance.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataRemittanceMoneyRepository extends JpaRepository<RemittanceMoneyJpaEntity, Long> {
}
