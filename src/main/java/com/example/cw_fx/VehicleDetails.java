package com.example.cw_fx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VehicleDetails {
    private SimpleStringProperty make;
    private SimpleStringProperty model;
    private SimpleIntegerProperty year;
    private SimpleIntegerProperty mileage;
    private SimpleStringProperty oldOwner;
    private SimpleIntegerProperty askPrice;
    private SimpleIntegerProperty sellPrice;
    private SimpleStringProperty availability;

    public VehicleDetails(String make, String model, Integer year, Integer mileage, String oldOwner, Integer askPrice, Integer sellPrice, String availability ) {
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleIntegerProperty(year);
        this.mileage = new SimpleIntegerProperty(mileage);
        this.oldOwner = new SimpleStringProperty(oldOwner);
        this.askPrice = new SimpleIntegerProperty(askPrice);
        this.sellPrice = new SimpleIntegerProperty(sellPrice);
        this.availability = new SimpleStringProperty(availability);

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

    public int getAskPrice() {
        return askPrice.get();
    }

    public SimpleIntegerProperty askPriceProperty() {
        return askPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice.set(askPrice);
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
}