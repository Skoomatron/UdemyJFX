package com.example.udemyjfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField mainField;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private CheckBox boxToggle;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize() {
        button1.setDisable(true);
        button2.setDisable(true);
    }
    @FXML
    public void onButtonClick(ActionEvent e) {
        if (e.getSource().equals(button1)) {
            System.out.println("Button1: " + mainField.getText());
        } else if (e.getSource().equals(button2)) {
            System.out.println("Button2: " + mainField.getText());
        }
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("Sleeping on: " + s);
                    Thread.sleep(3000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("Updating on: " + s);
                            ourLabel.setText("We did a thing");
                        }
                    });
                } catch (InterruptedException event) {
                    System.out.println("Error: " + event.getMessage());
                }
            }
        };

        new Thread(task).start();

        if (boxToggle.isSelected()) {
            mainField.clear();
            button1.setDisable(true);
            button2.setDisable(true);
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = mainField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        button1.setDisable(disableButtons);
        button2.setDisable(disableButtons);
    }
    @FXML
    public void handleChecking() {
        System.out.println("The checkbox is currently " + (boxToggle.isSelected() ? "checked" : "not checked"));
    }
}