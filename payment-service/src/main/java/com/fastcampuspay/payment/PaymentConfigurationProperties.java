package com.fastcampuspay.payment;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "banking")
public class PaymentConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;

}
