/**
 *
 *  @author Wierzba Kacper S30508
 *
 */

package zad1;



import zad1.gui.GuiHandler;


public class Main {
  public static void main(String[] args) {
    Service s = new Service("Poland");
    String weatherJson = s.getWeather("Warsaw");
    Double rate1 = s.getRateFor("USD");
    Double rate2 = s.getNBPRate();

    GuiHandler.main();

  }
}
