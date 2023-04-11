package com.fastcampuspay.payment.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
class PaymentJpaEntity {

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
