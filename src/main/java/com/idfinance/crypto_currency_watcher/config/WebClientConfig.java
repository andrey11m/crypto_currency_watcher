package com.idfinance.crypto_currency_watcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient coinLoreApiClient() {
        return WebClient.create("https://api.coinlore.net/api/ticker");
    }
}
