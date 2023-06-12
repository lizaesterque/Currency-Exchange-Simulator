package com.example;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrimaryController extends CurrencyConverterController{

    // acessing my text and comboBox using ID    
    @FXML
    public TextField userInput;    
    @FXML
    protected ComboBox <String> currency1;
    @FXML
    protected ComboBox <String> currency2;

    // a list of the options for my user to choose
    ObservableList<String> currencyList = FXCollections.observableArrayList("USD","CAD","BRL","EUR","GBP");    


    // the moment my app starts the items from my comboBox is set from my list
    @FXML
    private void initialize() {
        currency1.setItems(currencyList);
        currency2.setItems(currencyList);
    }    

    // when the user click in the button:
    /**
     * @throws IOException
     */
    @FXML
    private void currencyConvert() throws IOException {
        // selected the secondaryfmlx file
        App.setRoot("secondary");
        
        // save the option my user choose in the comboBox and from the textField
        String selectedItem1 = currency1.getSelectionModel().getSelectedItem();
        String selectedItem2 = currency2.getSelectionModel().getSelectedItem();
        String numb = userInput.getText();

        // convert the string to double
        double uservalue = Double.parseDouble(numb);
        
        // acessing my method from the SuperClass
        convert(selectedItem1,selectedItem2,uservalue);
    } 
}
