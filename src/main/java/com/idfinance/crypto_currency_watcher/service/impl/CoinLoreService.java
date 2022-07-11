package com.idfinance.crypto_currency_watcher.service.impl;

import com.idfinance.crypto_currency_watcher.model.CryptoCurrency;
import com.idfinance.crypto_currency_watcher.service.CryptoOpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinLoreService implements CryptoOpenApiService {

    private final WebClient coinLoreApiClient;

    @Value("${currency.ids}")
    private String idCurrencies;

    @Override
    public List<CryptoCurrency> getCryptoCurrencies() {
        List<CryptoCurrency> currencies = coinLoreApiClient
                .get()
                .uri("/?id=" + idCurrencies)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CryptoCurrency>>() {
                })
                .block();
        return currencies == null ? new ArrayList<>() : currencies;
    }
}
