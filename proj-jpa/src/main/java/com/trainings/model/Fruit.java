package com.trainings.model;


import jakarta.persistence.*;

@Entity
public class Fruit {
    @Id
    @TableGenerator(name="tablegen1",
            table="ID_TABLE", pkColumnName="ID", valueColumnName="NEXT_ID", allocationSize = 2)
    @GeneratedValue(strategy= GenerationType.TABLE,generator="tablegen1")
    public int id;

    public int vitaminAmount;

    public Fruit(int vitaminAmount) {
        this.vitaminAmount = vitaminAmount;
    }

    public Fruit() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVitaminAmount() {
        return vitaminAmount;
    }

    public void setVitaminAmount(int vitaminAmount) {
        this.vitaminAmount = vitaminAmount;
    }
}
