package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class AdminBuyController implements Initializable {
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
    @FXML
    private Button addAppointment;
    @FXML
    private ComboBox dealStatus = new ComboBox();

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
        dealStatus.getItems().add("Accepted");
        dealStatus.getItems().add("Rejected");

        try {
            List<String> orders = new ArrayList<String>();
            orders = Files.readAllLines(Paths.get("orders.txt"));
            String[] array = orders.toArray(new String[0]);

            for (int i = 0; i < orders.size(); i++) {
                String str = orders.get(i);
                String[] appointmentsSplit = str.split("#");
                CustomerDetails customer = new CustomerDetails(appointmentsSplit[0], appointmentsSplit[1], appointmentsSplit[2],
                        appointmentsSplit[3], appointmentsSplit[4], Integer.parseInt(appointmentsSplit[5]), Integer.parseInt(appointmentsSplit[6]),
                        appointmentsSplit[7], Integer.parseInt(appointmentsSplit[8]), appointmentsSplit[9], appointmentsSplit[10]);
                tableView.getItems().add(customer);
            }
        } catch (IOException e) {
        }

    }

    public void back(ActionEvent actionEvent) {
        try {
            HelloApplication m = new HelloApplication();
            m.navigate("adminHomePage-view.fxml");
        } catch (IOException e) {

        }
    }

    public void addDealStatus(ActionEvent actionEvent) {
        String stat = (String) dealStatus.getValue();
        try {
            CustomerDetails customer1 = tableView.getSelectionModel().getSelectedItem();

            CustomerDetails customer = new CustomerDetails(customer1.getCustomerName(), customer1.getAddress(), customer1.getPhoneNo(),
                    customer1.getMake(), customer1.getModel(), customer1.getYear(), customer1.getMileage(), customer1.getOldOwner(),
                    customer1.getSellPrice(), customer1.getAvailability(), stat);
            if (customer1 == null) {
                System.out.println("You have not selected a vehicle");
            } else {

                String customerName = customer.getCustomerName();
                String address = customer.getAddress();
                String phoneNo = customer.getPhoneNo();
                String make = customer.getMake();
                String model = customer.getModel();
                Integer year = customer.getYear();
                Integer mileage = customer.getMileage();
                String oldOwner = customer.getOldOwner();
                Integer sellPrice = customer.getSellPrice();
                String availability = customer.getAvailability();
                String status = customer.getStatus();
                tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
                tableView.getItems().add(customer);


                if (stat != null) {
                    try {
                        Writer details = new FileWriter("orders.txt", false);
                        for (int i = 0; i < tableView.getItems().size(); i++) {
                            details.write(colCustomerName.getCellData(i) + "#" + colAddress.getCellData(i) + "#" + colPhoneNo.getCellData(i) + "#" + colMake.getCellData(i) + "#" +
                                    colModel.getCellData(i) + "#" + colYear.getCellData(i) + "#" + colMileage.getCellData(i) +
                                    "#" + colOldOwner.getCellData(i) + "#" + colSellPrice.getCellData(i) + "#" +
                                    colAvailability.getCellData(i) + "#" + colStatus.getCellData(i) + "\n");
                        }
                        details.close();
                        System.out.println("Successfully saved");
                    } catch (Exception e) {
                        System.out.println("An error occurred while saving");
                    }
                } else {
                    System.out.println("You have not selected deal status");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("you have not selected a vehicle");
        }
    }
}