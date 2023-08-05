package com.fastcampuspay.membership.application.port.in;



import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public
class ValidateTokenCommand extends SelfValidating<ValidateTokenCommand> {
    private final String jwtToken;

}
