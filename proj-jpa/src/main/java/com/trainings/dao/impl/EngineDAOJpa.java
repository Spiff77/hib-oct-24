package com.trainings.dao.impl;

import com.trainings.dao.EngineDAO;
import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.model.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EngineDAOJpa implements EngineDAO {

    EntityManagerFactory emf = PersistenceUtils.getInstance().getEmf();

    @Override
    public List<Engine> findAll() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Engine> query = em.createQuery("FROM Engine ", Engine.class);
        List<Engine> resultList = query.getResultList();
        em.close();
        return resultList;
    }

    @Override
    public Engine find(Integer id) {
        EntityManager em = emf.createEntityManager();
        Engine c = em.find(Engine.class, id);
        em.close();
        return c;    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        Engine c = em.find(Engine.class, id);
        em.remove(c);
        em.close();
    }
}
