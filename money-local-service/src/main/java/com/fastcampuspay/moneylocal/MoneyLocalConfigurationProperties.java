package com.fastcampuspay.moneylocal;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "banking")
public class MoneyLocalConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;

}
