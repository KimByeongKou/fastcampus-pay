package com.fastcampuspay.settlement;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SettlementConfigurationProperties.class)
public class SettlementConfiguration {

}
