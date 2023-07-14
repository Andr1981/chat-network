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
import ru.parfandr.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


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
        authButton.setOnAction(event -> {
            String login = loginTextField.getCharacters().toString().trim();
            String password = passwordTextField.getCharacters().toString().trim();
            ifAuthValid(login, password);
        });
        registrationButton.setOnAction(event -> {
            Stage stage = (Stage) registrationButton.getScene().getWindow();
            stage.close();
            showRegInpurDataWindow(stage);
        });


    }

    private void ifAuthValid(String login, String password) {
        if (login.equals("") || password.equals("")) {
            showModalErrorWindow();
        } else {
            checkUserLoginPassword(login, password, Users.regUserData);
        }
    }

    private void checkUserLoginPassword(String login, String password, Map<String, ArrayList<Users>> regUserData) {
        if (regUserData.isEmpty()) {
            showModalErrorWindow();
        } else {
            for (Map.Entry<String, ArrayList<Users>> entry : regUserData.entrySet()) {
                if (entry.getKey().equals(login)) {
                    ArrayList<Users> usersValue = entry.getValue();
                    for (Users value : usersValue
                    ) {
                        if (value.getPassword().equals(password)) {
                            Stage stage = (Stage) authButton.getScene().getWindow();
                            stage.close();
                            System.out.println("Поздравляю, " + value.getName() + " " + value.getLastname() + " из " + value.getCountry()
                                    + ", вы вошли !");
                            showChatWindow();
                        } else {
                            System.out.println("Пароль не верен !");
                        }
                    }
                } else {
                    System.out.println("Такого логина нет !");
                }
            }
        }

    }

    private void showChatWindow() {
        String fxmlFile = "/views/chatwindow.fxml";
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

    public void showModalErrorWindow() {
        String fxmlFile = "/views/modalErrorRegWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private void showRegInpurDataWindow(Stage stage) {
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
    }

}
