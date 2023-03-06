package com.example.cw_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

public class MechanicViewController implements Initializable {
    @FXML
    private TableView<ServiceDetails> tableView;
    @FXML
    private TableColumn<ServiceDetails, String> colCustomerName;
    @FXML
    private TableColumn<ServiceDetails, String> colAddress;
    @FXML
    private TableColumn<ServiceDetails, String> colPhoneNo;
    @FXML
    private TableColumn<ServiceDetails, String> colMake;
    @FXML
    private TableColumn<ServiceDetails, String> colModel;
    @FXML
    private TableColumn<ServiceDetails, Integer> colYear;
    @FXML
    private TableColumn<ServiceDetails, String> colStatus;
    @FXML
    private TableColumn<ServiceDetails, Integer> colCost;
    @FXML
    private TextField tfCost;
    @FXML
    private Button back;
    @FXML
    private Button requestService;

    @Override

    public void initialize(URL url, ResourceBundle resources) {
        //set up columns in the table
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colMake.setCellValueFactory(new PropertyValueFactory<>("make"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colCustomerName.setCellFactory(TextFieldTableCell.forTableColumn());
        colAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        colPhoneNo.setCellFactory(TextFieldTableCell.forTableColumn());
        colMake.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colStatus.setCellFactory(TextFieldTableCell.forTableColumn());
        colCost.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        try {
            List<String> appointments = new ArrayList<String>();
            appointments = Files.readAllLines(Paths.get("car_service.txt"));
            String[] array = appointments.toArray(new String[0]);

            for (int i = 0; i < appointments.size(); i++) {
                String str = appointments.get(i);
                String[] appointmentsSplit = str.split("#");
                ServiceDetails service = new ServiceDetails(appointmentsSplit[0], appointmentsSplit[1], appointmentsSplit[2],
                        appointmentsSplit[3], appointmentsSplit[4], Integer.parseInt(appointmentsSplit[5]), appointmentsSplit[6], Integer.parseInt(appointmentsSplit[7]));
                tableView.getItems().add(service);
            }
        } catch (IOException e) {
        }

    }

    public void back(ActionEvent actionEvent) {
        try {
            HelloApplication m = new HelloApplication();
            m.navigate("employee-view.fxml");
        }
        catch (IOException e){

        }
    }

    public void addCost(ActionEvent actionEvent) {
        Integer x = Integer.parseInt(tfCost.getText());
        ServiceDetails service1 = tableView.getSelectionModel().getSelectedItem();

        ServiceDetails service = new ServiceDetails(service1.getCustomerName(), service1.getAddress(), service1.getPhoneNo(),
                service1.getMake(), service1.getModel(), service1.getYear(), "Finish", x);
        if (service1 == null) {
            System.out.println("You have not selected a vehicle");
        }
        else {

            String customerName = service.getCustomerName();
            String address = service.getAddress();
            String phoneNo = service.getPhoneNo();
            String make = service.getMake();
            String model = service.getModel();
            Integer year = service.getYear();
            String status = service.getStatus();
            Integer cost = service.getCost();
            tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
            tableView.getItems().add(service);


            if (customerName!="" && address!="" && phoneNo!="") {
                try {
                    Writer details = new FileWriter("car_service.txt", false);
                    for(int i = 0; i < tableView.getItems().size(); i++){
                        details.write(colCustomerName.getCellData(i)+"#"+colAddress.getCellData(i)+"#"+colPhoneNo.getCellData(i)+"#"+colMake.getCellData(i)+"#"+
                                colModel.getCellData(i)+"#"+colYear.getCellData(i)+"#"+colStatus.getCellData(i)+"#"+colCost.getCellData(i)+"\n");
                    }
                    details.close();
                    System.out.println("Successfully saved");
                } catch (Exception e) {
                    System.out.println("An error occurred while saving");
                }
            }
            else {
                System.out.println("You have left a blank space");
            }
        }
    }


    }

