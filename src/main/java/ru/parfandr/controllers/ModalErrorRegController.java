package ru.parfandr.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ModalErrorRegController {



    @FXML
    private Button okButton;

    @FXML
    void initialize() {
    okButton.setOnAction(event -> {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();

    });

    }

}