package com.trainings.model;


import jakarta.persistence.*;
import org.hibernate.type.YesNoConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@SecondaryTable(name="car_options", pkJoinColumns={
        @PrimaryKeyJoinColumn(name="a"),
        @PrimaryKeyJoinColumn(name="b")
})
@NamedQueries({
        @NamedQuery(name = "car.findAllByColor", query = "from Car c WHERE c.id.color = :color")
})
@DiscriminatorValue("c")
public class Car extends Vehicle implements Serializable {


    @Embedded
    private Address addressRegistration;

    @OneToMany(mappedBy = "car")
    private List<Seat> seats = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="eng_id")
    private Engine engine;

    public Car(CarId id, Engine engine, boolean isWorking) {
        super(id);
        this.engine = engine;
        this.isWorking = isWorking;
    }

    public Car() {
    }

    @Convert(converter = YesNoConverter.class)
    private boolean isWorking;

    @Column(table="car_options")
    private String option1;

    @Column(table="car_options")
    private String option2;

    @Column(table="car_options")
    private String option3;

    @ElementCollection
    private Set<Passenger> passengers;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
}
