package com.fastcampuspay.membership;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultToken;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

@Configuration
public class VaultConfiguration {

    @Value("${spring.cloud.vault.token}")
    private String vaultToken;

    @Value("${spring.cloud.vault.scheme}")
    private String vaultScheme;

    @Value("${spring.cloud.vault.host}")
    private String vaultHost;

    @Value("${spring.cloud.vault.port}")
    private int vaultPort;

    @Bean
    public VaultTemplate vaultTemplate() {
        VaultEndpoint endpoint = VaultEndpoint.create(vaultHost, vaultPort);
        endpoint.setScheme(vaultScheme);
        VaultTemplate template = new VaultTemplate(endpoint, () -> VaultToken.of(vaultToken));
        return template;
    }
}