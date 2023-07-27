package com.fastcampuspay.money.query.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneySum {
    private String regionName;
    private Long sum;
    private Date startDate;
}
