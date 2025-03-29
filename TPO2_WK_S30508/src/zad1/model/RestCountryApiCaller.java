package zad1.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestCountryApiCaller {

    public static String getCurrencyCode(String country) {

    String urlString = "https://restcountries.com/v3.1/name/" + country;
    try {

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) { // Success
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } else {
            System.out.println("Error: " + responseCode);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;

    }


}
