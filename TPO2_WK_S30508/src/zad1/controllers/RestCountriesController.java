package zad1.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import zad1.model.RestCountryApiCaller;

public class RestCountriesController {

    public static String getCurrencyCode(String country) {
        country = country.toLowerCase();
        Gson gson = new Gson();
        JsonObject[] countryData = gson.fromJson(RestCountryApiCaller.getCurrencyCode(country), JsonObject[].class);

        JsonObject currencies = countryData[0].getAsJsonObject("currencies");
        String currencyCode = currencies.entrySet().iterator().next().getKey();

        return currencyCode;
    }

}
