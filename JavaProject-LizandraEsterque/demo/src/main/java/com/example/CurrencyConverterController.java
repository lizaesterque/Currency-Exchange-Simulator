package com.example;

import java.util.HashMap;
import java.util.Map;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class CurrencyConverterController  {
    // acessing my text using ID   
    @FXML
    private Text value;

    @FXML
    private Text info;
    
    // creating variables outsite the method to be use in differents methods inside the class
    public static String userValue;
    public static String userInfo;
    private static double convertedValue;


    @FXML
    private void initialize() { 
        // using the run later to make sure the value will be set
        Platform.runLater(() -> {
            // adding text for my text on my interface
            value.setText(userValue);
            info.setText(userInfo);
        });
    }

    // button to the user come back to the first page
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }   

    // my fuction to be use in the moment the button is clicked
    public void convert(String item1, String item2,double value) {
        // Mapping of currency codes to exchange rates
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("CAD", 1.25);
        exchangeRates.put("BRL", 5.5);
        exchangeRates.put("EUR", 0.9);
        exchangeRates.put("GBP", 0.8);

    // Calculate the exchange rate
    double rate1to2 = exchangeRates.get(item2) / exchangeRates.get(item1);
    convertedValue = value * rate1to2;    

    // saving the information in string format   
    userInfo =  String.format("Exchange rate from %s to %s: %.2f", item1, item2, rate1to2);    
    userValue =  String.format("$%.2f", convertedValue);
    
    }
}