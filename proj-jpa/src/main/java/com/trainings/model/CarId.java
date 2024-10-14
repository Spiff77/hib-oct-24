package com.trainings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;


@Embeddable
public class CarId {

    @Column(name = "marque")
    private String brand;

    @Column
    private String color;

    public CarId() {
    }


    public CarId(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarId carId)) return false;
        return Objects.equals(brand, carId.brand) && Objects.equals(color, carId.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
