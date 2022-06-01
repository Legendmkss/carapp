package com.example.carapp_diploma.Models;

import java.util.Date;

public class Car {
    private String name, brand, fuel, year, mileage, consumption;

    public Car(){}

    public Car(String name, String brand, String year, String mileage, String consumption, String fuel) {
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
        this.consumption = consumption;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }
}
