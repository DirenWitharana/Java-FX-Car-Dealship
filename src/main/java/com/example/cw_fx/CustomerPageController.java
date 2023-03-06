package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class CustomerPageController {
    @FXML
    private Label welcomeCustomer;
    @FXML
    private Button carSale;
    @FXML
    private Button carService;

    @FXML
    public void carSaleIn(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("customerBuy-view.fxml");
    }

    @FXML
    public void serviceIn(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("customerService-view.fxml");
    }

    public void back(ActionEvent actionEvent) {
        try {
            HelloApplication m = new HelloApplication();
            m.navigate("hello-view.fxml");
        }
        catch (IOException e){

        }
    }

}
