package com.trainings.dao.impl;

import com.trainings.dao.CarDAO;
import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.model.Car;
import com.trainings.model.CarId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CarDAOJpa implements CarDAO {

    EntityManagerFactory emf = PersistenceUtils.getInstance().getEmf();

    @Override
    public List<Car> findByColor(String color) {
        return List.of();
    }

    @Override
    public List<Car> findAll() {

        EntityManager em = null;
        List<Car> resultList = null;

        try{
            em = PersistenceUtils.getInstance().getEmf().createEntityManager();
            TypedQuery<Car> query = em.createQuery("FROM Car", Car.class);
            resultList = query.getResultList();
            em.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(em != null && em.isOpen()){
                em.close();
            }
        }

        return resultList;
    }

    @Override
    public Car find(CarId id) {
        EntityManager em = emf.createEntityManager();
        Car c = em.find(Car.class, id);
        em.close();
        return c;
    }

    @Override
    public void delete(CarId id) {
        EntityManager em = emf.createEntityManager();
        Car c = em.find(Car.class, id);
        em.remove(c);
        em.close();
    }
}
