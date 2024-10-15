package com.trainings.dao;

import com.trainings.model.Car;
import com.trainings.model.CarId;

import java.util.List;

public interface CarDAO extends GenericDAO<CarId, Car>{
    List<Car> findByColor(String color);

}
