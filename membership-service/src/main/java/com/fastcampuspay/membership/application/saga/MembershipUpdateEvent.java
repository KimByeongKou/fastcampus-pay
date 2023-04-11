package com.fastcampuspay.membership.application.saga;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MembershipUpdateEvent {
    private String membershipId;
    private String name;
    private String email;
    private String address;
}
