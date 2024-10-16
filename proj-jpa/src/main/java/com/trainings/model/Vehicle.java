package com.trainings.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class Vehicle implements Serializable {

    public static final String F_OWNERS = "owners";


    @EmbeddedId
    private CarId id;

    @ManyToMany(mappedBy = "carsOwned", fetch = FetchType.LAZY)
    Set<Owner> owners = new HashSet<>();

    public Vehicle() {
    }

    public Vehicle(CarId id) {
        this.id = id;
    }

    public void setId(CarId id) {
        this.id = id;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
}
