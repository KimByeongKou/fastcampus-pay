package com.fastcampuspay.money.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recharge_money")
@Data
@AllArgsConstructor
@NoArgsConstructor
class RechargeMoneyJpaEntity {

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
