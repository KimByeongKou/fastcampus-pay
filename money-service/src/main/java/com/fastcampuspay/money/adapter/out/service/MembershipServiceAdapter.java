package com.fastcampuspay.money.adapter.out.service;

import com.fastcampuspay.common.CommonHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MembershipServiceAdapter {

    private final CommonHttpClient commonHttpClient;

    private final String membershipServiceUrl;

    public MembershipServiceAdapter(CommonHttpClient commonHttpClient,
                                    @Value("${service.membership.url}") String membershipServiceUrl) {
        this.commonHttpClient = commonHttpClient;
        this.membershipServiceUrl = membershipServiceUrl;
    }

    public String getMembershipByMembershipId(String membershipId) {
        try {
            return commonHttpClient.sendGetRequest(membershipServiceUrl + "/membership/" + membershipId).body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
