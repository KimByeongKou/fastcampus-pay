package com.fastcampuspay.money.application.port.out;

public interface GetMembershipPort {
    MembershipStatus getMembership(String membershipId);
}
