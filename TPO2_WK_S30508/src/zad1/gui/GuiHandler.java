package zad1.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import zad1.Service;

public class GuiHandler extends Application {


    private String country;
    private String city;
    private String currencycode;

    @Override
    public void start(Stage primaryStage) {


        Label countryLabel = new Label("Enter country:");
        TextField CountryField = new TextField();

        Label cityLabel = new Label("Enter city:");
        TextField CityField = new TextField();

        Label currencyLabel = new Label("Enter currency code:");
        TextField CurrencyCodeField = new TextField();

        Button submitButton = new Button("Submit");

        VBox layout1 = new VBox(10);
        layout1.setAlignment(Pos.TOP_CENTER);

        layout1.getChildren().addAll(countryLabel, CountryField, cityLabel, CityField,currencyLabel, CurrencyCodeField, submitButton);


        TextArea consoleArea = new TextArea();
        consoleArea.setEditable(false);
        consoleArea.setWrapText(true);


        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();


        GridPane layout = new GridPane();
        layout.add(layout1, 0, 0);
        layout.add(consoleArea, 0, 1);
        layout.add(webView, 1, 0,1,2);

        Scene scene = new Scene(layout, 1000, 500);
        primaryStage.setTitle("Data Input Form");
        primaryStage.setScene(scene);
        primaryStage.show();


        submitButton.setOnAction(e -> {
            consoleArea.clear();
            country = CountryField.getText();
            city = CityField.getText();
            currencycode = CurrencyCodeField.getText();
            Service ser = new Service(country);
            consoleArea.appendText(ser.getActualWeather(city)+"\n");
            consoleArea.appendText("exchange rate between: "+ser.getCurrcode()+" and "+currencycode.toUpperCase()+": "+ser.getRateFor(currencycode) + "\n");
            consoleArea.appendText("exchange rate between: "+ser.getCurrcode()+" and PLN:" +ser.getNBPRate() + "\n");

            String url = "https://en.wikipedia.org/wiki/" + city;
            webEngine.load(url);
        });
    }

    public static void main() {
        launch();
    }

}
