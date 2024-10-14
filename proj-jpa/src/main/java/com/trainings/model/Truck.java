package com.trainings.model;


import jakarta.persistence.*;
import org.hibernate.type.YesNoConverter;

import java.io.Serializable;

@Entity
public record Truck(
    @Id Long id,
    String name
){}
