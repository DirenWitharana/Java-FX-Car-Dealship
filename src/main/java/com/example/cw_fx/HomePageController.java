package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomePageController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button customer;
    @FXML
    private Button employee;

    public HomePageController() {
    }

    @FXML
    public void employeeIn(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("employee-view.fxml");
    }

    @FXML
    public void customerIn(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("customer-view.fxml");
    }
}
