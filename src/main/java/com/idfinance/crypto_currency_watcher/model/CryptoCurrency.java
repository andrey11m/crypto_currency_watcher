package com.idfinance.crypto_currency_watcher.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class CryptoCurrency {

    @Id
    private Long id;
    private String symbol;
    private String name;
    @JsonAlias("nameid")
    private String nameId;
    private String rank;
    @JsonAlias("price_usd")
    private double priceUsd;
    @JsonAlias("percent_change_24h")
    private String percentChange24h;
    @JsonAlias("percent_change_1h")
    private String percentChange1h;
    @JsonAlias("percent_change_7d")
    private String percentChange7d;
    @JsonAlias("market_cap_usd")
    private String marketCapUsd;
    private String volume24;
    @JsonAlias("volume24_native")
    private String volume24Native;
    @JsonAlias("csupply")
    private String cSupply;
    @JsonAlias("priceBtc")
    private String price_btc;
    @JsonAlias("tsupply")
    private String tSupply;
    @JsonAlias("msupply")
    private String mSupply;
}
