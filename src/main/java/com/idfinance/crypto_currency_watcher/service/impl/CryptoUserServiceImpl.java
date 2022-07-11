package com.idfinance.crypto_currency_watcher.service.impl;

import com.idfinance.crypto_currency_watcher.model.CryptoUser;
import com.idfinance.crypto_currency_watcher.repo.CryptoUserRepository;
import com.idfinance.crypto_currency_watcher.service.CryptoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoUserServiceImpl implements CryptoUserService {

    private final CryptoUserRepository userRepository;

    @Override
    public CryptoUser save(CryptoUser user) {
        return userRepository.save(user);
    }

    @Override
    public List<CryptoUser> getAllUsers() {
        return userRepository.findAll();
    }
}
