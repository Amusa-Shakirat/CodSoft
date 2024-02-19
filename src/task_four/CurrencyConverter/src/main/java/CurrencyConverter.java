import org.json.JSONObject;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class CurrencyConverter {

    private static final String API_KEY = "ea001de0b71c4418b5aa4e265eaaf8aa";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base currency: ");
        String baseCurrency = input.nextLine().toUpperCase();

        System.out.print("Enter the target currency: ");
        String targetCurrency = input.nextLine().toUpperCase();

        System.out.print("Enter the amount: ");
        double amountToBeConverted = input.nextDouble();


        try {
            String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency + ".json?apikey=" + API_KEY;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());

                double exchangeRate = jsonResponse.getJSONObject("rates").getDouble(targetCurrency);

                double convertedAmount = amountToBeConverted * exchangeRate;

                System.out.println(amountToBeConverted + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
            } else {
                System.out.println("Error: Unable to fetch exchange rates. HTTP error code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

