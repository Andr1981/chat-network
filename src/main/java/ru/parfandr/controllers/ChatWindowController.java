package ru.parfandr.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ChatWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSend;

    @FXML
    private ListView<?> chatPane;

    @FXML
    private TextArea messageBox;

    @FXML
    private ListView<?> userPane;

    @FXML
    void initialize() {

    }

}
