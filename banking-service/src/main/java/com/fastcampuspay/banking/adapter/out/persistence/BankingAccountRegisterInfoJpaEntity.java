package com.fastcampuspay.banking.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banking_account_register_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
class BankingAccountRegisterInfoJpaEntity {

	@Id
	@GeneratedValue
	private Long registerInfoId;

//	private String name;
//
//	private String address;
//
//	private String email;
//
//	private boolean isValid;

}
