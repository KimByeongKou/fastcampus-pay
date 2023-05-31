package com.fastcampuspay.membership;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "membership")
public class MembershipConfigurationProperties {


}
