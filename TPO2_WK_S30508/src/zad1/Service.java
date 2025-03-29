/**
 *
 *  @author Wierzba Kacper S30508
 *
 */

package zad1;


import zad1.controllers.CurrencyController;
import zad1.controllers.RestCountriesController;
import zad1.model.RestCountryApiCaller;
import zad1.model.WeatherApiCaller;

public class Service {

    String country;

    public Service(String country) {
        this.country = country;
    }

    public String getWeather(String city) {
        return WeatherApiCaller.getWeather(city);
    }

    public double getRateFor(String currency) {
        String code = RestCountriesController.getCurrencyCode(currency);
        return CurrencyController.getExchangeRates(code, currency);
    }


    public Double getNBPRate() {
        return 0d;
    }
}
