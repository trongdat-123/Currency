package com.example.currency;

public class CurrencyData {
    public static Currency[] getCurrencies(){
        com.example.currency.Currency currency1 = new com.example.currency.Currency("Vietnam", "dong", "đ", 1);
        com.example.currency.Currency currency2 = new com.example.currency.Currency("USA", "USD", "$", 23209.5);
        com.example.currency.Currency currency3 = new com.example.currency.Currency("Europa", "Euro", "C", 24721.71);

        com.example.currency.Currency[] currencies = {currency1, currency2, currency3};
        return currencies;
    }
}
