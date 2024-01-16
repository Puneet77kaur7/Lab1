
package org.example.lab;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CurrencyConverterController {

    private double convertedValue;
    private double finalValue;

    @FXML
    private TextField inputAmountField;

    @FXML
    private TextField resultField;

    @FXML
    private ComboBox<String> sourceCurrencyCombo;

    @FXML
    private ComboBox<String> targetCurrencyCombo;

    @FXML
    private Button conversionButton;

    @FXML
    protected void initialize() {
        sourceCurrencyCombo.getItems().addAll("USD", "EUR", "GBP", "CAD");
        targetCurrencyCombo.getItems().addAll("USD", "EUR", "GBP", "CAD");
    }

    @FXML
    protected void convert() {
        String sourceCurrency = sourceCurrencyCombo.getValue();
        String targetCurrency = targetCurrencyCombo.getValue();
        try {
            double enteredAmount = Double.parseDouble(inputAmountField.getText());
            double convertedToUSD = convertToUSD(sourceCurrency, enteredAmount);
            double finalConversion = convertFromUSD(targetCurrency, convertedToUSD);
            resultField.setText(String.format("%.2f %s", finalConversion, targetCurrency));
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
        }
    }

    private double convertToUSD(String sourceCurrency, double originalAmount) {
        if ("USD".equals(sourceCurrency)) {
            return originalAmount;
        } else if ("EUR".equals(sourceCurrency)) {
            return originalAmount * 1.10;
        } else if ("GBP".equals(sourceCurrency)) {
            return originalAmount * 1.27;
        } else if ("CAD".equals(sourceCurrency)) {
            return originalAmount * 0.75;
        } else {
            throw new IllegalArgumentException("Unsupported source currency");
        }
    }

    private double convertFromUSD(String targetCurrency, double usdAmount) {
        if ("USD".equals(targetCurrency)) {
            return usdAmount;
        } else if ("EUR".equals(targetCurrency)) {
            return usdAmount * 0.91;
        } else if ("GBP".equals(targetCurrency)) {
            return usdAmount * 0.78;
        } else if ("CAD".equals(targetCurrency)) {
            return usdAmount * 1.34;
        } else {
            throw new IllegalArgumentException("Unsupported target currency");
        }
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public double getFinalValue() {
        return finalValue;
    }
}