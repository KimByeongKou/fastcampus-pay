package com.fastcampuspay.payment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataPaymentRepository extends JpaRepository<PaymentJpaEntity, Long> {
}
