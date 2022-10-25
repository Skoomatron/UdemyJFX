package com.example.udemyjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField mainField;
    @FXML
    private Button button1;
    @FXML
    private Button button2;

    @FXML
    public void onButtonClick(ActionEvent e) {
        if (e.getSource().equals(button1)) {
            System.out.println("Button1: " + mainField.getText());
        } else if (e.getSource().equals(button2)) {
            System.out.println("Button2: " + mainField.getText());
        }
    }
}