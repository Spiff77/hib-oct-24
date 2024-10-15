package com.trainings.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;

@Entity
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int power;

    @OneToOne(mappedBy = "engine")
    private Car car;

    public Engine(int power) {
        this.power = power;
    }

    @Enumerated(EnumType.STRING)
    private EngineType type;

    public Engine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }
}
