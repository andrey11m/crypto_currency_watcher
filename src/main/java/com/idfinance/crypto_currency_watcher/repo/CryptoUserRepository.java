package com.idfinance.crypto_currency_watcher.repo;

import com.idfinance.crypto_currency_watcher.model.CryptoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoUserRepository extends JpaRepository<CryptoUser, Long> {

}
