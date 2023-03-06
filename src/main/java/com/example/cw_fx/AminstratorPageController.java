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

public class AminstratorPageController implements Initializable {
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
    private TableColumn<VehicleDetails, Integer> colAskPrice;
    @FXML
    private TableColumn<VehicleDetails, Integer> colSellPrice;
    @FXML
    private TableColumn<VehicleDetails, String> colAvailability;
    @FXML
    private TextField tfMake;
    @FXML
    private TextField tfModel;
    @FXML
    private TextField tfYear;
    @FXML
    private TextField tfMileage;
    @FXML
    private TextField tfOldOwner;
    @FXML
    private TextField tfAskPrice;
    @FXML
    private TextField tfSellPrice;

    public AminstratorPageController() throws IOException {
    }

    @Override

    public void initialize(URL url, ResourceBundle resources) {
        //set up columns in the table
        colMake.setCellValueFactory(new PropertyValueFactory<>("make"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        colOldOwner.setCellValueFactory(new PropertyValueFactory<>("oldOwner"));
        colAskPrice.setCellValueFactory(new PropertyValueFactory<>("askPrice"));
        colSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        tableView.setEditable(true);
        colMake.setCellFactory(TextFieldTableCell.forTableColumn());
        colModel.setCellFactory(TextFieldTableCell.forTableColumn());
        colYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colMileage.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colOldOwner.setCellFactory(TextFieldTableCell.forTableColumn());
        colAskPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
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


    public void addCar(ActionEvent actionEvent) {
        try {
            VehicleDetails vehicle = new VehicleDetails(tfMake.getText(), tfModel.getText(),
                    Integer.parseInt(tfYear.getText()), Integer.parseInt(tfMileage.getText()),
                    tfOldOwner.getText(), Integer.parseInt(tfAskPrice.getText()),
                    Integer.parseInt(tfSellPrice.getText()), "On Sale");

            tableView.getItems().add(vehicle);
            tfMake.clear();
            tfModel.clear();
            tfYear.clear();
            tfMileage.clear();
            tfOldOwner.clear();
            tfAskPrice.clear();
            tfSellPrice.clear();
        }
        catch (Exception e) {
            System.out.println("Ooops! You have entered incorrect information");

        }
    }

    public void saveCar(ActionEvent actionEvent) {
        try{
            Writer details = new FileWriter("vehicles.txt",false);
            for(int i = 0; i < tableView.getItems().size(); i++){
                details.write(colMake.getCellData(i)+"#"+colModel.getCellData(i)+"#"+colYear.getCellData(i)+
                        "#"+colMileage.getCellData(i)+"#"+colOldOwner.getCellData(i)+"#"
                        +colAskPrice.getCellData(i)+"#"+colSellPrice.getCellData(i)+"#"+
                        colAvailability.getCellData(i)+"\n");
            }
            details.close();
            System.out.println("Successfully saved");
        }
            catch (Exception e){
                System.out.println("An error occurred");
            }
        }

    public void back(ActionEvent actionEvent) {
        try {
            HelloApplication m = new HelloApplication();
            m.navigate("adminHomePage-view.fxml");
        }
        catch (IOException e){

        }
    }

    public void deleteCar(ActionEvent actionEvent){
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
    }

    public void editCar(ActionEvent actionEvent){
        VehicleDetails vehicle = tableView.getSelectionModel().getSelectedItem();
        if (vehicle == null) {
            System.out.println("You have not selected a vehicle");
        }
        else {
            String make = vehicle.getMake();
            String model = vehicle.getModel();
            Integer year = vehicle.getYear();
            Integer mileage = vehicle.getMileage();
            String oldOwner = vehicle.getOldOwner();
            Integer askPrice = vehicle.getAskPrice();
            Integer sellPrice = vehicle.getSellPrice();
            String availability = vehicle.getAvailability();

            tfMake.setText(make);
            tfModel.setText(model);
            tfYear.setText(year.toString());
            tfMileage.setText(mileage.toString());
            tfOldOwner.setText(oldOwner);
            tfAskPrice.setText(askPrice.toString());
            tfSellPrice.setText(sellPrice.toString());

            deleteCar(actionEvent);

        }


    }
    }




