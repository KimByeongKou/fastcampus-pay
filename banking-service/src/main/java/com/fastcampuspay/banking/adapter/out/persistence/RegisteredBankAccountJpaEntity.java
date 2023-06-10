package com.fastcampuspay.banking.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registered_bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue
    private Long membershipId;


    public RegisteredBankAccountJpaEntity(String name, String address, String email, boolean isValid, boolean isCorp) {

    }

    @Override
    public String toString() {
        return "RegisteredBankAccountJpaEntity{" +
                "membershipId=" + membershipId +
                '}';
    }
}
