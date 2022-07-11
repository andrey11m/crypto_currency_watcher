package com.idfinance.crypto_currency_watcher.controller;

import com.idfinance.crypto_currency_watcher.model.CryptoCurrency;
import com.idfinance.crypto_currency_watcher.model.CryptoUser;
import com.idfinance.crypto_currency_watcher.service.CryptoCurrencyService;
import com.idfinance.crypto_currency_watcher.service.CryptoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CryptoCurrencyService currencyServer;
    private final CryptoUserService userService;

    @GetMapping("/price")
    public double getPrice(String symbol) {
        return currencyServer.getCryptoCurrencyBySymbol(symbol).getPriceUsd();
    }

    @GetMapping("/available-currencies")
    public List<CryptoCurrency> getAvailable() {
        return currencyServer.getAllCurrencies();
    }

    @PostMapping("/notify")
    public CryptoUser notifyUser(String username, String symbol) {
        CryptoCurrency currency = currencyServer.getCryptoCurrencyBySymbol(symbol);
        CryptoUser user = CryptoUser
                .builder()
                .username(username)
                .symbol(symbol)
                .price(currency.getPriceUsd())
                .build();
        return userService.save(user);
    }
}
