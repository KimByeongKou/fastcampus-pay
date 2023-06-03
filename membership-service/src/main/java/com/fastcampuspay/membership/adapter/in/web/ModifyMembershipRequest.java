package com.fastcampuspay.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyMembershipRequest {
    private String membershipId;
    private String name;
    private String address;
    private String email;

    private boolean isValid;
    private boolean isCorp;
}
