package com.idfinance.crypto_currency_watcher.repo;

import com.idfinance.crypto_currency_watcher.model.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    Optional<CryptoCurrency> findCryptoCurrencyBySymbol(String symbol);

}
