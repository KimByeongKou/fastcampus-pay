package com.fastcampuspay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataFirmbankingRequestRepository extends JpaRepository<FirmbankingRequestJpaEntity, Long> {

    @Query("SELECT e  FROM FirmbankingRequestJpaEntity e WHERE e.aggregateIdentifier = :aggregateIdentifier")
    List<FirmbankingRequestJpaEntity> findByAggregateIdentifier(@Param("aggregateIdentifier") String aggregateIdentifier);
}
