package com.example.udemyjfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField mainField;
    public void onButtonClick() {
        System.out.println("Yeeeeee " + mainField.getText());
    }
}