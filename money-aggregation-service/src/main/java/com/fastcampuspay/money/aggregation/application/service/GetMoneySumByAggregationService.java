package com.fastcampuspay.money.aggregation.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.money.aggregation.application.port.in.GetMoneySumByAddressCommand;
import com.fastcampuspay.money.aggregation.application.port.in.GetMoneySumByAddressUseCase;
import com.fastcampuspay.money.aggregation.application.port.out.GetMembershipPort;
import com.fastcampuspay.money.aggregation.application.port.out.GetMoneySumPort;
import com.fastcampuspay.money.aggregation.application.port.out.MemberMoney;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UseCase
@RequiredArgsConstructor
@Transactional
public class GetMoneySumByAggregationService implements GetMoneySumByAddressUseCase {

    private final GetMoneySumPort getMoneySumPort;
    private final GetMembershipPort getMembershipPort;
    @Override
    public int getMoneySumByAddress(GetMoneySumByAddressCommand command) {
        // Aggregation 을 위한 비즈니스 로직
        // 강남구, 서초구, 관악구
        String targetAddress = command.getAddress();
        List<String> membershipIds = getMembershipPort.getMembershipByAddress(targetAddress);

        List<List<String>> membershipPartitionList = null;
        if (membershipIds.size() > 100) {
            membershipPartitionList = partitionList(membershipIds, 100);
        }

        int sum = 0;
        for (List<String> partitionedList : membershipPartitionList) {
            // 100 개씩 요청해서, 값을 계산하기로 설계.
            List<MemberMoney> memberMoneyList = getMoneySumPort.getMoneySumByMembershipIds(partitionedList);

            for (MemberMoney memberMoney : memberMoneyList) {
                sum += memberMoney.getBalance();
            }
        }

        return sum;
    }
    // List 를 n개씩 묶어서 List<List<T>>로 만드는 메서드
    private static <T> List<List<T>> partitionList(List<T> list, int partitionSize) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.groupingBy(index -> index / partitionSize))
                .values()
                .stream()
                .map(indices -> indices.stream().map(list::get).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
