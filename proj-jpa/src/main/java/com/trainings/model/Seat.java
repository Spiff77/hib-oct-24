package com.trainings.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String color;
    private String serialNumber;
    private boolean isOccuped;

    @ManyToOne
    private Car car;

    public Seat( String color, String serialNumber, boolean isOccuped) {
        this.color = color;
        this.serialNumber = serialNumber;
        this.isOccuped = isOccuped;
    }

    public Seat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isOccuped() {
        return isOccuped;
    }

    public void setOccuped(boolean occuped) {
        isOccuped = occuped;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
