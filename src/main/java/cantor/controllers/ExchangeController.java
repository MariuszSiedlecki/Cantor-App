package cantor.controllers;

import cantor.helpers.DecimalCustomFormat;
import cantor.model.CurrencyApplicationModels;
import cantor.model.ExchangeModel;
import cantor.office.Currency;
import cantor.office.ExchangeOffice;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ExchangeController {
    @FXML
    public TextField currencyInputTextField;
    @FXML
    public Button calculateButton;
    @FXML
    public TextArea resultViewTextArea;
    @FXML
    public MenuButton currencyMenuButtonFrom;
    @FXML
    public MenuButton currencyMenuButtonTo;
    @FXML
    public DatePicker datePicker;

    @FXML
    public void initialize() {
        getConfigureCurrencyButtons();

    }

    public void getConfigureCurrencyButtons() {
        for (Currency c : Currency.values()) {
            currencyMenuButtonFrom.getItems().add(new MenuItem(c.getName()));
            currencyMenuButtonTo.getItems().add(new MenuItem(c.getName()));
        }
        currencyMenuButtonFrom.getItems().forEach(i -> i.setOnAction(a -> {
            currencyMenuButtonFrom.setText(i.getText());
        }));

        currencyMenuButtonTo.getItems().forEach(i -> i.setOnAction(a -> {
            currencyMenuButtonTo.setText(i.getText());
        }));

        datePicker.setValue(LocalDate.now());

    }

    @FXML
    public void performResult() {
        ExchangeOffice office = new ExchangeOffice(1000);
        CurrencyApplicationModels applicationModel = office.exchange(new BigDecimal(
                        currencyInputTextField.getText()),
                Currency.valueOf(currencyMenuButtonFrom.getText()),
                Currency.valueOf(currencyMenuButtonTo.getText())
        );
        applicationModel.setDate(datePicker.getValue());
        resultViewTextArea.setText(
                applicationModel.getDate()
                        + "\n "
                        + " waluta wymiany z : "
                        + applicationModel.getFrom()
                        + "\n "
                        + " waluta wymiany na : "
                        + applicationModel.getTo()
                        + "\n "
                        + " aktualny kurs "
                        + DecimalCustomFormat.decimalGetRate(applicationModel.getRate())
                        + "\n "
                        + " wydaj w : "
                        + applicationModel.getTo()
                        + " \n "
                        + " kwotę : "
                        + DecimalCustomFormat.decimalToString(applicationModel.getResult())
        );
    }

    public void calculate() {
        performResult();
    }
}