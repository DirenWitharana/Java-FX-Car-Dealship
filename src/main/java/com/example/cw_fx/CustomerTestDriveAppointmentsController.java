package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerTestDriveAppointmentsController implements Initializable {
    @FXML
    private TableView<CustomerDetails> tableView;
    @FXML
    private TableColumn<CustomerDetails, String> colCustomerName;
    @FXML
    private TableColumn<CustomerDetails, String> colAddress;
    @FXML
    private TableColumn<CustomerDetails, String> colPhoneNo;
    @FXML
    private TableColumn<CustomerDetails, String> colMake;
    @FXML
    private TableColumn<CustomerDetails, String> colModel;
    @FXML
    private TableColumn<CustomerDetails, Integer> colYear;
    @FXML
    private TableColumn<CustomerDetails, Integer> colMileage;
    @FXML
    private TableColumn<CustomerDetails, String> colOldOwner;
    @FXML
    private TableColumn<CustomerDetails, Integer> colSellPrice;
    @FXML
    private TableColumn<CustomerDetails, String> colAvailability;
    @FXML
    private TableColumn<CustomerDetails, String> colStatus;
    @FXML
    private Button back;

    public CustomerTestDriveAppointmentsController() throws IOException {
    }

    @Override

    public void initialize(URL url, ResourceBundle resources) {
        //set up columns in the table
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colMake.setCellValueFactory(new PropertyValueFactory<>("make"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        colOldOwner.setCellValueFactory(new PropertyValueFactory<>("oldOwner"));
        colSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colCustomerName.setCellFactory(TextFieldTableCell.forTableColumn());
        colAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        colPhoneNo.setCellFactory(TextFieldTableCell.forTableColumn());
        colMake.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colMileage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colOldOwner.setCellFactory(TextFieldTableCell.forTableColumn());
        colSellPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAvailability.setCellFactory(TextFieldTableCell.forTableColumn());
        colStatus.setCellFactory(TextFieldTableCell.forTableColumn());


        try {
            List<String> appointments = new ArrayList<String>();
            appointments = Files.readAllLines(Paths.get("test_drive.txt"));
            String[] array = appointments.toArray(new String[0]);

            for (int i = 0; i < appointments.size(); i++) {
                String str = appointments.get(i);
                String[] appointmentsSplit = str.split("#");
                CustomerDetails customer = new CustomerDetails(appointmentsSplit[0], appointmentsSplit[1], appointmentsSplit[2],
                        appointmentsSplit[3], appointmentsSplit[4], Integer.parseInt(appointmentsSplit[5]), Integer.parseInt(appointmentsSplit[6]),
                        appointmentsSplit[7],Integer.parseInt(appointmentsSplit[8]),appointmentsSplit[9],appointmentsSplit[10]);
                tableView.getItems().add(customer);
            }
        } catch (IOException e) {
        }

    }

    public void back(ActionEvent actionEvent) {
        try {
            HelloApplication m = new HelloApplication();
            m.navigate("customerBuy-view.fxml");
        }
        catch (IOException e){

        }
    }
}
