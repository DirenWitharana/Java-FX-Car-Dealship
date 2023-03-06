package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class EmployeePageController {
    @FXML
    private Label welcomeEmp;
    @FXML
    private Button owner;
    @FXML
    private Button adminstrator;
    @FXML
    private Button mechanic;
    @FXML
    private Button back;

    @FXML
    public void ownerIn(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("owner-view.fxml");
    }

    public void adminstratorIn(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("adminHomePage-view.fxml");
    }

    public void mechanicIn(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("mechanic-view.fxml");
    }

    public void goBack(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("hello-view.fxml");
    }

}
