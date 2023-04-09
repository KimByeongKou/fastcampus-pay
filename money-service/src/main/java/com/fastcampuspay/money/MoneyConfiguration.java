package com.fastcampuspay.money;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MoneyConfigurationProperties.class)
public class MoneyConfiguration {

}
