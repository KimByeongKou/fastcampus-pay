package com.fastcampuspay.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMembershipRequest {
    private String membershipId;
    private String name;

    private String address;

    private String email;

    private boolean isValid;
}
