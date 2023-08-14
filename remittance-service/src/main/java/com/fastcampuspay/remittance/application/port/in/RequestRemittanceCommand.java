package com.fastcampuspay.remittance.application.port.in;

import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RequestRemittanceCommand extends SelfValidating<RequestRemittanceCommand> {

    @NotNull
    private String fromMembershipId; // from membership

    private String toMembershipId; // to membership

    private String toBankName;

    private String toBankAccountNumber;

    private int remittanceType; // 0: membership(내부 고객), 1: bank (외부 은행 계좌)

    // 송금요청 금액
    @NotNull
    private int amount;

    public RequestRemittanceCommand(String fromMembershipId, String toMembershipId, String toBankName, String toBankAccountNumber, int remittanceType, int amount) {
        this.fromMembershipId = fromMembershipId;
        this.toMembershipId = toMembershipId;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.remittanceType = remittanceType;
        this.amount = amount;

        this.validateSelf();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestRemittanceCommand command = (RequestRemittanceCommand) o;
        return remittanceType == command.remittanceType && amount == command.amount && fromMembershipId.equals(command.fromMembershipId) && toMembershipId.equals(command.toMembershipId) && toBankName.equals(command.toBankName) && toBankAccountNumber.equals(command.toBankAccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromMembershipId, toMembershipId, toBankName, toBankAccountNumber, remittanceType, amount);
    }
}
