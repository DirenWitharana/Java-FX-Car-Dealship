package com.example.cw_fx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustomerDetails {
    private SimpleStringProperty customerName;
    private SimpleStringProperty address;
    private SimpleStringProperty phoneNo;
    private SimpleStringProperty make;
    private SimpleStringProperty model;
    private SimpleIntegerProperty year;
    private SimpleIntegerProperty mileage;
    private SimpleStringProperty oldOwner;
    private SimpleIntegerProperty sellPrice;
    private SimpleStringProperty availability;
    private SimpleStringProperty status;


    public CustomerDetails(String customerName, String address, String phoneNo, String make, String model, Integer year, Integer mileage, String oldOwner, Integer sellPrice,String availability, String status) {
        this.customerName = new SimpleStringProperty(customerName);
        this.address = new SimpleStringProperty(address);
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleIntegerProperty(year);
        this.mileage = new SimpleIntegerProperty(mileage);
        this.oldOwner = new SimpleStringProperty(oldOwner);
        this.sellPrice = new SimpleIntegerProperty(sellPrice);
        this.availability = new SimpleStringProperty(availability);
        this.status  =new SimpleStringProperty(status);

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

    public int getMileage() {
        return mileage.get();
    }

    public SimpleIntegerProperty mileageProperty() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage.set(mileage);
    }

    public String getOldOwner() {
        return oldOwner.get();
    }

    public SimpleStringProperty oldOwnerProperty() {
        return oldOwner;
    }

    public void setOldOwner(String oldOwner) {
        this.oldOwner.set(oldOwner);
    }

    public int getSellPrice() {
        return sellPrice.get();
    }

    public SimpleIntegerProperty sellPriceProperty() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice.set(sellPrice);
    }

    public String getAvailability() {
        return availability.get();
    }

    public SimpleStringProperty availabilityProperty() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability.set(availability);
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
}


