/**
 *
 *  @author Wierzba Kacper S30508
 *
 */

package zad1;


import zad1.controllers.*;
import zad1.model.WeatherApiCaller;

public class Service {

    String country;
    String currcode;

    public Service(String country) {
        this.country = country;
        currcode = CountryCurrencyCodeController.getCode(country);
    }

    public String getWeather(String city) {
        return WeatherApiCaller.getWeather(city);
    }

    public double getRateFor(String currency) {
        return CurrencyController.getExchangeRates(currcode, currency);
    }

    public Double getNBPRate() {
        if(currcode.equals("PLN"))
            return 1d;
        return NbpController.getRateToPLN(currcode);
    }

    public String getActualWeather(String city) {
        return WeatherController.getWeather(city);
    }

    public String getCountry() {
        return country;
    }

    public String getCurrcode() {
        return currcode;
    }
}
