package com.fastcampuspay.money.query.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneySumByRegion {
    @Getter private final String moneySumByRegionId;
    @Getter private final String regionName;
    @Getter private final long moneySum;

    public static MoneySumByRegion generateMoneySumByRegion (
            MoneySumByRegionId moneySumByRegionId,
            RegionName regionName,
            MoneySum moneySum
    ){
        return new MoneySumByRegion(
                moneySumByRegionId.moneySumByRegionId,
                regionName.regionName,
                moneySum.moneySum
        );
    }

    @Value
    public static class MoneySumByRegionId {
        public MoneySumByRegionId(String value) {
            this.moneySumByRegionId = value;
        }
        String moneySumByRegionId ;
    }

    @Value
    public static class RegionName {
        public RegionName(String value) {
            this.regionName = value;
        }
        String regionName ;
    }

    @Value
    public static class MoneySum {
        public MoneySum(int value) {
            this.moneySum = value;
        }
        int moneySum ;
    }
}
