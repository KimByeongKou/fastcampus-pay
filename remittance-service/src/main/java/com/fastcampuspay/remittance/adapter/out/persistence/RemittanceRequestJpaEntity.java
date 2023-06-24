package com.fastcampuspay.remittance.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "request_remittance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemittanceRequestJpaEntity {
    @Id
    @GeneratedValue
    private Long remittanceRequestId;

}
