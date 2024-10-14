package com.trainings.model;


import jakarta.persistence.*;
import org.hibernate.type.YesNoConverter;

import java.io.Serializable;

@Entity
@SecondaryTable(name="car_options")
public class Car implements Serializable {

    @EmbeddedId
    private CarId id;

    @Embedded
    private Address addressRegistration;

    @Convert(converter = YesNoConverter.class)
    private boolean isWorking;

    @Column(table="car_options")
    private String option1;

    @Column(table="car_options")
    private String option2;

    @Column(table="car_options")
    private String option3;

    public Car(CarId id, boolean isWorking) {
        this.id = id;
        this.isWorking = isWorking;
    }

    public Car() {

    }

    public CarId getId() {
        return id;
    }

    public void setId(CarId id) {
        this.id = id;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Address getAddressRegistration() {
        return addressRegistration;
    }

    public void setAddressRegistration(Address addressRegistration) {
        this.addressRegistration = addressRegistration;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }
}
