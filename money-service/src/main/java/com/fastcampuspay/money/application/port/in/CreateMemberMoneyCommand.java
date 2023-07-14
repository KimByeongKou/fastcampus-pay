package com.fastcampuspay.money.application.port.in;


import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class CreateMemberMoneyCommand extends SelfValidating<CreateMemberMoneyCommand> {

    @NotNull
    private final String targetMembershipId;

    public CreateMemberMoneyCommand(@NotNull String targetMembershipId) {
        this.targetMembershipId = targetMembershipId;
        this.validateSelf();
    }
}
