package com.fastcampuspay.membership.application.port.in;



import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public
class FindMembershipListByAddressCommand extends SelfValidating<FindMembershipListByAddressCommand> {
    private final String addressName; // 관악구, 서초구, 강남구

}
