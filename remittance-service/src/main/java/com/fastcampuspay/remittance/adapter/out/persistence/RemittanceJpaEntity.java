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
@Table(name = "remittance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemittanceJpaEntity {
    @Id
    @GeneratedValue
    private Long remittanceId;

    private String status;

    public RemittanceJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmbankingStatus, UUID uuid) {
       
    }

}
