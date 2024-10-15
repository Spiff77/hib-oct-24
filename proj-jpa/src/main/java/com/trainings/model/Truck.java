package com.trainings.model;


import jakarta.persistence.*;
import org.hibernate.type.YesNoConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@SecondaryTable(name="car_options")
@DiscriminatorValue("t")
public class Truck extends Vehicle implements Serializable {


    @Embedded
    private Address addressRegistration;

    @OneToMany(mappedBy = "car")
    private List<Seat> seats = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="eng_id")
    private Engine engine;

    private boolean remorquable;

    public Truck(CarId id, Engine engine, boolean remorquable) {
        super(id);
        this.engine = engine;
        this.remorquable = remorquable;
    }

    public Truck() {

    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
}
