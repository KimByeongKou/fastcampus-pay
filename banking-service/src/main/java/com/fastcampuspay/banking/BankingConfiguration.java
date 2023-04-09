package com.fastcampuspay.banking;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BankingConfigurationProperties.class)
public class BankingConfiguration {

}
