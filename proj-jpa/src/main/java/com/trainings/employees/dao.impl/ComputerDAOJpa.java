package com.trainings.employees.dao.impl;

import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.employees.dao.ComputerDAO;
import com.trainings.employees.model.Computer;
import com.trainings.employees.model.ComputerId;
import com.trainings.model.Car;
import com.trainings.model.CarId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ComputerDAOJpa implements ComputerDAO {

    EntityManagerFactory emf = PersistenceUtils.getInstance().getEmf();


    @Override
    public List<Computer> findAll() {

        EntityManager em = null;
        List<Computer> resultList = null;

        try{
            em = PersistenceUtils.getInstance().getEmf().createEntityManager();
            TypedQuery<Computer> query = em.createQuery("FROM Computer", Computer.class);
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
    public Computer find(ComputerId id) {
        EntityManager em = emf.createEntityManager();
        Computer c = em.find(Computer.class, id);
        em.close();
        return c;
    }

    @Override
    public void delete(ComputerId id) {
        EntityManager em = emf.createEntityManager();
        Computer c = em.find(Computer.class, id);
        em.remove(c);
        em.close();
    }
}
