package zad1.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import zad1.model.WeatherApiCaller;

public class WeatherController {

    public static String getWeather(String city) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(WeatherApiCaller.getWeather(city), JsonObject.class);

        // Pobieranie głównych informacji
        JsonObject main = jsonObject.getAsJsonObject("main");
        double temperature = main.has("temp") ? main.get("temp").getAsDouble() : Double.NaN;
        int pressure = main.has("pressure") ? main.get("pressure").getAsInt() : 0;
        int humidity = main.has("humidity") ? main.get("humidity").getAsInt() : 0;

        // Pobieranie informacji o pogodzie
        JsonElement weatherElement = jsonObject.getAsJsonArray("weather").get(0);
        JsonObject weather = weatherElement.getAsJsonObject();
        String description = weather.has("description") ? weather.get("description").getAsString() : "No description";

        city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();

        return city + "\n" +"temperature: "+temperature+"\n"+"pressure: "+pressure+"\n"+"humidity: "+humidity+"\n"+"description: "+description+"\n";
    }

}
