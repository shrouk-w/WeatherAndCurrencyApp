package zad1.controllers;

import java.util.Currency;
import java.util.Locale;

public class CountryCurrencyCodeController {

    public static String getCode(String country) {


        String input = country.trim().toLowerCase();
        String[] countryCodes = Locale.getISOCountries();

        for (String code : countryCodes) {
            Locale locale = new Locale("", code);
            String countryName = locale.getDisplayCountry(Locale.ENGLISH).toLowerCase();

            if (countryName.equals(input)) {
                try {
                    return  Currency.getInstance(locale).getCurrencyCode();
                } catch (IllegalArgumentException e) {
                    return "usd";
                }
            }
        }
        return "usd";
    }



}
