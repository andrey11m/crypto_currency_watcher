package com.idfinance.crypto_currency_watcher.service;

import com.idfinance.crypto_currency_watcher.model.CryptoCurrency;
import com.idfinance.crypto_currency_watcher.model.CryptoUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateInfoService {

    private final CryptoUserService userService;
    private final CryptoCurrencyService currencyService;

    @Scheduled(fixedRateString = "PT40S")
    public void doRepeat() {
        List<CryptoCurrency> currencies = currencyService.updateInfo();
        List<CryptoUser> users = userService.getAllUsers();
        users.forEach(user -> checkChanges(user, currencies));
    }

    private void checkChanges(CryptoUser user, List<CryptoCurrency> currencies) {
        currencies.forEach(currency -> {
            if (user.getSymbol().equals(currency.getSymbol())) {
                double changePercent = (Math.abs(user.getPrice() - currency.getPriceUsd())) / user.getPrice() * 100;
                if (changePercent > 1) {
                    log.warn("Symbol: {}, username: {}, percent change: {}", user.getSymbol(), user.getUsername(), changePercent);
                }
            }
        });
    }
}
