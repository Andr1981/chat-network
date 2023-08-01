package ru.parfandr.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ChatWindowController {


    @FXML
    private Button buttonSend;

    @FXML
    private ListView<?> chatPane;

    @FXML
    private TextArea messageBox;

    @FXML
    private ListView<String> userPane;

    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Andrey", "Ivan", "Boris", "Olga");

        userPane.setItems(list);

    }
}
