package com.fastcampuspay.remittance;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "banking")
public class RemittanceConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;

}
