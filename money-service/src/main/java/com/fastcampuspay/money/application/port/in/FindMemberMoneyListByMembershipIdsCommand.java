package com.fastcampuspay.money.application.port.in;

import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMemberMoneyListByMembershipIdsCommand extends SelfValidating<FindMemberMoneyListByMembershipIdsCommand> {
    @NotNull
    private final List<String> membershipIds;

    public FindMemberMoneyListByMembershipIdsCommand(@NotNull List<String> targetMembershipId) {
        this.membershipIds = targetMembershipId;
        this.validateSelf();
    }
}
