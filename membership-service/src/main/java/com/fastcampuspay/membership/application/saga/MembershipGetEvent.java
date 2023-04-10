package com.fastcampuspay.membership.application.saga;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MembershipGetEvent {
    private String membershipId;
}
