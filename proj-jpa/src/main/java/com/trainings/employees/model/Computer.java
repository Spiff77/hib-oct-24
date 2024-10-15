package com.trainings.employees.model;

import jakarta.persistence.Cacheable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Computer  implements Serializable {
    @EmbeddedId
    private ComputerId id;

    int memory;

    @OneToOne(mappedBy = "computer")
    Employee employee;

    public Computer(ComputerId id, int memory) {
        this.id = id;
        this.memory = memory;
    }

    public Computer() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ComputerId getId() {
        return id;
    }

    public void setId(ComputerId id) {
        this.id = id;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
