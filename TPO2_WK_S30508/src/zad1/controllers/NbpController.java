package zad1.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import zad1.model.NbpApiCaller;

public class NbpController {

    public static double getRateToPLN(String currency)
    {
        currency = currency.toLowerCase();
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(NbpApiCaller.getRateToPLN(currency), JsonObject.class);;
        JsonObject rates = jsonResponse.getAsJsonArray("rates").get(0).getAsJsonObject();
        double exchangeRate = rates.get("mid").getAsDouble();
        return exchangeRate;
    }

}
