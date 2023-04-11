package com.fastcampuspay.settlement;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "banking")
public class SettlementConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;

}
