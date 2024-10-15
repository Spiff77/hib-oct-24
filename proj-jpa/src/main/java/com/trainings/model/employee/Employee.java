package com.trainings.model.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee extends Person implements Serializable {

    @OneToOne
    Computer computer;

    @ManyToOne
    Department department;

    private Date hiredate = new Date();

    public Employee() {}

    public Employee(String firstname, String lastname, String password, Date hiredate) {
        super(firstname, lastname, password);
        this.hiredate = hiredate;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
