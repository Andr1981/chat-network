package ru.parfandr.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.parfandr.Users;

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
            String login = loginInputField.getCharacters().toString();
            String password = passwordInputField.getCharacters().toString();
            String name = nameInputField.getCharacters().toString();
            String lastname = lastnameInputField.getCharacters().toString();
            String country = countryInputField.getCharacters().toString();
            ifDataValid(login, password, name, lastname, country);

        });

    }

    public void ifDataValid(String log, String pass, String name, String lastname, String country) {
        if (log.equals("") || pass.equals("") || name.equals("") || lastname.equals("") || country.equals("")) {
            System.out.println("No valid");
        } else {
            Users users = new Users(log, pass, name, lastname, country);
            ArrayList<String> userData = new ArrayList<>();
            userData.add(pass);
            userData.add(name);
            userData.add(lastname);
            userData.add(country);
            users.regUserData.put(log, userData);

        }


    }


}


