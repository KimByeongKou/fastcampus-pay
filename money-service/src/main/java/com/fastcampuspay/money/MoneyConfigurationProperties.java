package com.fastcampuspay.money;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "banking")
public class MoneyConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;

}
