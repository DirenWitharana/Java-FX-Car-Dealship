package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class AdminHomePageController {
    @FXML
    private Label welcomeAdmin;
    @FXML
    private Button addAndEditCar;
    @FXML
    private Button buyer;
    @FXML
    private Button testDrive;
    @FXML
    private Button back;

    public AdminHomePageController() {
    }

    @FXML
    public void addCarPage(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("adminstrator-view.fxml");
    }

    @FXML
    public void buyRequests(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("adminBuy-view.fxml");
    }

    @FXML
    public void testDriveRequests(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("adminTestDrive-view.fxml");
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("employee-view.fxml");
    }
}
