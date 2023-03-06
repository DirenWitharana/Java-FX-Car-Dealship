package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class CustomerBuyPageController  implements Initializable {
    @FXML
    private TableView<VehicleDetails> tableView;
    @FXML
    private TableColumn<VehicleDetails, String> colMake;
    @FXML
    private TableColumn<VehicleDetails, String> colModel;
    @FXML
    private TableColumn<VehicleDetails, Integer> colYear;
    @FXML
    private TableColumn<VehicleDetails, Integer> colMileage;
    @FXML
    private TableColumn<VehicleDetails, String> colOldOwner;
    @FXML
    private TableColumn<VehicleDetails, Integer> colSellPrice;
    @FXML
    private TableColumn<VehicleDetails, String> colAvailability;
    @FXML
    private TextField tfCustomerName;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfPhoneNo;


    public CustomerBuyPageController() throws IOException {

    }

    @Override

    public void initialize(URL url, ResourceBundle resources) {
        //set up columns in the table
        colMake.setCellValueFactory(new PropertyValueFactory<>("make"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        colOldOwner.setCellValueFactory(new PropertyValueFactory<>("oldOwner"));
        colSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colMake.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colMileage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colOldOwner.setCellFactory(TextFieldTableCell.forTableColumn());
        colSellPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAvailability.setCellFactory(TextFieldTableCell.forTableColumn());

        try {
            List<String> vehicles = new ArrayList<String>();
            vehicles = Files.readAllLines(Paths.get("vehicles.txt"));
            String[] array = vehicles.toArray(new String[0]);

            for (int i = 0; i < vehicles.size(); i++) {
                String str = vehicles.get(i);
                String[] vehiclesSplit = str.split("#");
                VehicleDetails vehicle = new VehicleDetails(vehiclesSplit[0], vehiclesSplit[1], Integer.parseInt(vehiclesSplit[2]),
                        Integer.parseInt(vehiclesSplit[3]), vehiclesSplit[4], Integer.parseInt(vehiclesSplit[5]), Integer.parseInt(vehiclesSplit[6]), "On Sale");
                tableView.getItems().add(vehicle);
            }
        } catch (IOException e) {
        }

    }

    public void requestTestDrive(ActionEvent actionEvent) {
        try {
            VehicleDetails vehicle = tableView.getSelectionModel().getSelectedItem();

            CustomerDetails customer = new CustomerDetails(tfCustomerName.getText(), tfAddress.getText(), tfPhoneNo.getText(),
                    vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getMileage(), vehicle.getOldOwner(),
                    vehicle.getSellPrice(), vehicle.getAvailability(), "Pending");


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


                if (customerName != "" && address != "" && phoneNo != "") {
                    try {
                        Writer details = new FileWriter("test_drive.txt", true);
                        details.write(customerName + "#" + address + "#" + phoneNo + "#" + make + "#" + model + "#" + year + "#" + mileage + "#"
                                + oldOwner + "#" + sellPrice + "#" + availability + "#" + status + "\n");

                        details.close();
                        System.out.println("Successfully saved");
                    } catch (Exception e) {
                        System.out.println("An error occurred while saving");
                    }
                } else {
                    System.out.println("You have left a blank space");
                }
        }
        catch (NullPointerException e) {
            System.out.println("You have not selected a vehicle from the table");
        }
    }

    public void orderCar (ActionEvent actionEvent){
        try {
            VehicleDetails vehicle = tableView.getSelectionModel().getSelectedItem();

            CustomerDetails customer = new CustomerDetails(tfCustomerName.getText(), tfAddress.getText(), tfPhoneNo.getText(),
                    vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getMileage(), vehicle.getOldOwner(),
                    vehicle.getSellPrice(), vehicle.getAvailability(), "Pending");


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


                if (customerName != "" && address != "" && phoneNo != "") {
                    try {
                        Writer details = new FileWriter("orders.txt", true);
                        details.write(customerName + "#" + address + "#" + phoneNo + "#" + make + "#" + model + "#" + year + "#" + mileage + "#"
                                + oldOwner + "#" + sellPrice + "#" + availability + "#" + status + "\n");

                        details.close();
                        System.out.println("Successfully saved");
                    } catch (Exception e) {
                        System.out.println("An error occurred while saving");
                    }
                } else {
                    System.out.println("You have left a blank space");
                }
            }
            catch (NullPointerException e) {
                System.out.println("You have not selected a vehicle from the table");
            }
        }

    @FXML
    public void viewAppointments(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.navigate("customerTestDriveAppointments-view.fxml");
    }
    public void back(ActionEvent actionEvent) {
        try {
            HelloApplication m = new HelloApplication();
            m.navigate("customer-view.fxml");
        }
        catch (IOException e){

        }
    }




    }

