package com.fastcampuspay.remittance;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RemittanceConfigurationProperties.class)
public class RemittanceConfiguration {

}
