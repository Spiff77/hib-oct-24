package com.trainings.employees.model;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class User extends Person  implements Serializable {

    @Convert(converter = org.hibernate.type.YesNoConverter.class)
    private boolean vip = false;

    public User(String firstname, String lastname, String password, boolean vip) {
        super(firstname, lastname, password);
        this.vip = vip;
    }


    public User() {

    }
}
