package com.fastcampuspay.money.aggregation.adapter.out.service;

import com.fastcampuspay.common.CommonHttpClient;
import com.fastcampuspay.common.ExternalSystemAdapter;
import com.fastcampuspay.money.aggregation.application.port.out.GetMembershipPort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.List;
import java.util.stream.Collectors;

@ExternalSystemAdapter
public class MembershipServiceAdapter implements GetMembershipPort {

    private final CommonHttpClient commonHttpClient;

    private final String membershipServiceUrl;

    public MembershipServiceAdapter(CommonHttpClient commonHttpClient,
                                     @Value("${service.membership.url}") String membershipServiceUrl) {
        this.commonHttpClient = commonHttpClient;
        this.membershipServiceUrl = membershipServiceUrl;
    }

    @Override
    public List<String> getMembershipByAddress(String address) {
        String url = String.join("/", membershipServiceUrl, "membership/address", address);
        try {
            String jsonResponse = commonHttpClient.sendGetRequest(url).body();

            ObjectMapper mapper = new ObjectMapper();
            List<Membership> membershipList = mapper.readValue(jsonResponse, new TypeReference<>() {});
            List<String> membershipIds = membershipList.stream()
                    .map(Membership::getMembershipId)
                    .collect(Collectors.toList());

            return membershipIds;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
