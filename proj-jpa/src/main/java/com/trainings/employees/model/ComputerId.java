package com.trainings.employees.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class ComputerId implements java.io.Serializable {
    @ManyToOne
    private Department department;

    private String name;

    public ComputerId() {}

    public ComputerId(Department department, String name) {
        this.department = department;
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerId that = (ComputerId) o;
        return Objects.equals(department, that.department) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, name);
    }
}
