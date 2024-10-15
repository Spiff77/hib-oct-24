package com.trainings.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;
    Date birthdate;

    @ManyToMany()
    @JoinTable(
            name="car_proprio", joinColumns={@JoinColumn(name = "ownerId")},
            inverseJoinColumns={@JoinColumn(name = "car_brand"), @JoinColumn(name = "car_color")}
    )
    Set<Vehicle> carsOwned = new HashSet<>();

    public Owner() {
    }

    public Owner(Date birthdate, String name) {
        this.birthdate = birthdate;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Vehicle> getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(Set<Vehicle> carsOwned) {
        this.carsOwned = carsOwned;
    }

    public void add(Vehicle c){
        this.carsOwned.add(c);
    }
}
