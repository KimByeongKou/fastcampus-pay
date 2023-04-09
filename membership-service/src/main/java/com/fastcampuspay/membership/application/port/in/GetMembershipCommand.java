package com.fastcampuspay.membership.application.port.in;


import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
@EqualsAndHashCode(callSuper = false)
public
class GetMembershipCommand extends SelfValidating<GetMembershipCommand> {
    @NotNull
    private final String membershipId;

}
