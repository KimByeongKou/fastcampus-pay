package com.fastcampuspay.payment.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payment_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentJpaEntity {
    @Id
    @GeneratedValue
    private Long paymentId;
    private String requestMembershipId;
    private int requestPrice;
    private String franchiseId;
    private String franchiseFeeRate;
    private int paymentStatus;  // 0: 승인, 1: 실패, 2: 정산 완료.
    private Date approvedAt;

    public PaymentJpaEntity(String requestMembershipId, int requestPrice, String franchiseId, String franchiseFeeRate, int paymentStatus, Date approvedAt) {
        this.requestMembershipId = requestMembershipId;
        this.requestPrice = requestPrice;
        this.franchiseId = franchiseId;
        this.franchiseFeeRate = franchiseFeeRate;
        this.paymentStatus = paymentStatus;
        this.approvedAt = approvedAt;
    }

    @Override
    public String toString() {
        return "PaymentJpaEntity{" +
                "paymentId=" + paymentId +
                ", requestMembershipId='" + requestMembershipId + '\'' +
                ", requestPrice=" + requestPrice +
                ", franchiseId='" + franchiseId + '\'' +
                ", franchiseFeeRate='" + franchiseFeeRate + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", approvedAt=" + approvedAt +
                '}';
    }
}
