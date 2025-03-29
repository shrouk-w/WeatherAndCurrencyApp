package zad1.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import zad1.model.CurrencyApiCaller;

public class CurrencyController {

    public static double getExchangeRates(String defaultcurrency, String currency) {
        defaultcurrency = defaultcurrency.toUpperCase();
        currency = currency.toUpperCase();

        Gson gson = new Gson();
        JsonObject CurrencyData = gson.fromJson(CurrencyApiCaller.getExchangeRates(defaultcurrency, currency), JsonObject.class);
        return CurrencyData.get("conversion_rate").getAsDouble();
    }

}
