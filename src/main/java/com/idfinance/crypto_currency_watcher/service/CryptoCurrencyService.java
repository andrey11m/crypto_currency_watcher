package com.idfinance.crypto_currency_watcher.service;

import com.idfinance.crypto_currency_watcher.model.CryptoCurrency;

import java.util.List;

public interface CryptoCurrencyService {
    List<CryptoCurrency> updateInfo();

    CryptoCurrency getCryptoCurrencyBySymbol(String symbol);

    List<CryptoCurrency> getAllCurrencies();
}
