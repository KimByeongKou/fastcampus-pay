package com.fastcampuspay.remittance.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "remittance_money")
@Data
@AllArgsConstructor
@NoArgsConstructor
class RemittanceMoneyJpaEntity {
	@Id
	@GeneratedValue
	private Long remittanceMoneyId;

//	private String name;
//
//	private String address;
//
//	private String email;
//
//	private boolean isValid;

}
