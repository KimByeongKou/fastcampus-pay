package com.fastcampuspay.membership.application.port.out.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindMembershipQuery {
    String membershipId;
}
