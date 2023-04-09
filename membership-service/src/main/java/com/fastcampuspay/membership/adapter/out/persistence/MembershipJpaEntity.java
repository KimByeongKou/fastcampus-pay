package com.fastcampuspay.membership.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
class MembershipJpaEntity {

	@Id
	@GeneratedValue
	private Long membershipId;

	private String name;

	private String address;

	private String email;

	private boolean isValid;

	public MembershipJpaEntity(String name, String address, String email, boolean isValid) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "MembershipJpaEntity{" +
				"membershipId=" + membershipId +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", isValid=" + isValid +
				'}';
	}
}
