package ru.parfandr.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class AuthController {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registrationButton;

    @FXML
    private Button authButton;

    @FXML
    private TextField loginTextField;


    @FXML
    void initialize() {
        registrationButton.setOnAction(event -> {
            Stage stage = (Stage) registrationButton.getScene().getWindow();
            stage.close();
            String fxmlFile = "/views/reginputdatawindow.fxml";
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = loader.load(getClass().getResourceAsStream(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(new Scene(root));
            stage.show();
        });

    }
}
