package com.trainings.dao.impl;

import com.trainings.dao.CarDAO;
import com.trainings.model.Car;
import com.trainings.model.CarId;

import java.util.List;

public class CarDAOHibernate implements CarDAO {
    @Override
    public List<Car> findByColor(String color) {
        return List.of();
    }

    @Override
    public List<Car> findAll() {
        return List.of();
    }

    @Override
    public Car find(CarId id) {
        return null;
    }

    @Override
    public void delete(CarId id) {

    }
}
