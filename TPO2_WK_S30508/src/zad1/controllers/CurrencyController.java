package zad1.controllers;

import zad1.model.CurrencyApiCaller;

public class CurrencyController {

    public static String getExchangeRates(String defaultcurrency, String currency) {
        defaultcurrency = defaultcurrency.toUpperCase();
        currency = currency.toUpperCase();
        return CurrencyApiCaller.getExchangeRates(defaultcurrency, currency);
    }

}
