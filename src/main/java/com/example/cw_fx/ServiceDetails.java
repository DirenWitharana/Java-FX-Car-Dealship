package com.example.cw_fx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServiceDetails {
    private SimpleStringProperty customerName;
    private SimpleStringProperty address;
    private SimpleStringProperty phoneNo;
    private SimpleStringProperty make;
    private SimpleStringProperty model;
    private SimpleIntegerProperty year;
    private SimpleStringProperty status;
    private SimpleIntegerProperty cost;


    public ServiceDetails(String customerName, String address, String phoneNo, String make, String model, Integer year, String status, Integer cost) {
        this.customerName = new SimpleStringProperty(customerName);
        this.address = new SimpleStringProperty(address);
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleIntegerProperty(year);
        this.status  =new SimpleStringProperty(status);
        this.cost = new SimpleIntegerProperty(cost);

    }

    public String getCustomerName() {
        return customerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhoneNo() {
        return phoneNo.get();
    }

    public SimpleStringProperty phoneNoProperty() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo.set(phoneNo);
    }

    public String getMake() {
        return make.get();
    }

    public SimpleStringProperty makeProperty() {
        return make;
    }

    public void setMake(String make) {
        this.make.set(make);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public int getCost() {
        return cost.get();
    }

    public SimpleIntegerProperty costProperty() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost.set(cost);
    }
}
