package com.idfinance.crypto_currency_watcher.service;

import com.idfinance.crypto_currency_watcher.model.CryptoUser;

import java.util.List;

public interface CryptoUserService {
    CryptoUser save(CryptoUser user);

    List<CryptoUser> getAllUsers();
}
