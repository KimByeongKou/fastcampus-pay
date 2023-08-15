package com.fastcampuspay.membership.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "membership")
@Data
@NoArgsConstructor
public class MembershipJpaEntity {

    @Id
    @GeneratedValue
    private Long membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private boolean isCorp;
    private String refreshToken;

    public MembershipJpaEntity(String name, String address, String email, boolean isValid, boolean isCorp, String refreshToken) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "MembershipJpaEntity{" +
                "membershipId=" + membershipId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", isValid=" + isValid +
                ", isCorp=" + isCorp +
                ", refreshToken=" + refreshToken +
                '}';
    }

    public MembershipJpaEntity(Long membershipId, String name, String address, String email, boolean isValid, boolean isCorp, String refreshToken) {
        this.membershipId = membershipId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.refreshToken = refreshToken;
    }

    public MembershipJpaEntity clone() {
        return new MembershipJpaEntity(this.membershipId, this.name, this.address, this.email, this.isValid, this.isCorp, this.refreshToken);
    }
}
