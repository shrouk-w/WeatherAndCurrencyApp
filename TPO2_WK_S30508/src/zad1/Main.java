/**
 *
 *  @author Wierzba Kacper S30508
 *
 */

package zad1;


import zad1.controllers.CurrencyController;
import zad1.controllers.RestCountriesController;
import zad1.model.CurrencyApiCaller;
import zad1.model.RestCountryApiCaller;
import zad1.model.WeatherApiCaller;

public class Main {
  public static void main(String[] args) {
    Service s = new Service("Poland");
    String weatherJson = s.getWeather("Warsaw");
    Double rate1 = s.getRateFor("USD");
    Double rate2 = s.getNBPRate();
    // ...
    // część uruchamiająca GUI





  }
}
