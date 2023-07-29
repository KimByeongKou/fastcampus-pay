package com.fastcampuspay.payment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataPaymentRepository extends JpaRepository<PaymentJpaEntity, Long> {
    @Query("SELECT e  FROM PaymentJpaEntity e WHERE e.paymentStatus = :paymentStatus")
    List<PaymentJpaEntity> findByPaymentStatus(@Param("paymentStatus") int paymentStatus);
}
