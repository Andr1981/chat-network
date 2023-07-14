package ru.parfandr.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.parfandr.AuthClass;
import ru.parfandr.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegistrationController {

    @FXML
    private TextField loginInputField;

    @FXML
    private Button registrationEntryButton;

    @FXML
    private TextField nameInputField;

    @FXML
    private TextField countryInputField;

    @FXML
    private PasswordField passwordInputField;

    @FXML
    private TextField lastnameInputField;


    @FXML
    void initialize() {
        registrationEntryButton.setOnAction(event -> {
            String login = loginInputField.getCharacters().toString().trim();
            String password = passwordInputField.getCharacters().toString().trim();
            String name = nameInputField.getCharacters().toString().trim();
            String lastname = lastnameInputField.getCharacters().toString().trim();
            String country = countryInputField.getCharacters().toString().trim();
            boolean valid = ifDataValid(login, password, name, lastname, country);
            if (valid) {
                Stage stage = (Stage) registrationEntryButton.getScene().getWindow();
                stage.close();
                showregistrationWindow();
            }

        });

    }


    public boolean ifDataValid(String log, String pass, String name, String lastname, String country) {
        if (log.equals("") || pass.equals("") || name.equals("") || lastname.equals("") || country.equals("")) {
            showModalErrorWindow();
            return false;

        } else {
            Users users = new Users(pass, name, lastname, country);
            ArrayList<Users> userData = new ArrayList<>();
            userData.add(users);
            Users.regUserData.put(log, userData);
            return true;

        }


    }

    private void showModalErrorWindow() {
        String fxmlFile = "/views/modalErrorRegWindow.fxml";
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            root = loader.load(getClass().getResourceAsStream(fxmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private void showregistrationWindow() {
        String fxmlFile = "/views/registrationwindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root));
        stage1.show();
    }


}


