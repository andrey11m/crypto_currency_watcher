package com.idfinance.crypto_currency_watcher.service.impl;

import com.idfinance.crypto_currency_watcher.model.CryptoCurrency;
import com.idfinance.crypto_currency_watcher.repo.CryptoCurrencyRepository;
import com.idfinance.crypto_currency_watcher.service.CryptoCurrencyService;
import com.idfinance.crypto_currency_watcher.service.CryptoOpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {

    private final CryptoCurrencyRepository currencyRepository;
    private final CryptoOpenApiService cryptoOpenApiService;

    @Override
    public List<CryptoCurrency> updateInfo() {
        List<CryptoCurrency> cryptoCurrencies = cryptoOpenApiService.getCryptoCurrencies();
        return currencyRepository.saveAll(cryptoCurrencies);
    }

    @Override
    public CryptoCurrency getCryptoCurrencyBySymbol(String symbol) {
        return currencyRepository.findCryptoCurrencyBySymbol(symbol)
                .orElseThrow(() -> new RuntimeException(String.format("%s not found", symbol)));
    }

    @Override
    public List<CryptoCurrency> getAllCurrencies() {
        return currencyRepository.findAll();
    }
}
