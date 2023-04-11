package com.fastcampuspay.moneylocal.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "local_money")
@Data
@AllArgsConstructor
@NoArgsConstructor
class LocalMoneyJpaEntity {

	@Id
	@GeneratedValue
	private Long rechargeMoneyId;

//	private String name;
//
//	private String address;
//
//	private String email;
//
//	private boolean isValid;

}
