package zad1.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbpApiCaller {

    public static String getRateToPLN(String currency) {

        String[] wompwomp = {"A", "B", "C"};

        for(String womp : wompwomp) {
            String urlstring = "https://api.nbp.pl/api/exchangerates/rates/"+ womp +"/" + currency + "/?format=json";
            try {
                URL url = new URL(urlstring);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();


                    return response.toString();

                }else if(responseCode == 404){
                    continue;
                }
                else {
                    System.out.println("Error: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
