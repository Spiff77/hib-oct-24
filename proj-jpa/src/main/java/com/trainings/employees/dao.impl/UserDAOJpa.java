package com.trainings.employees.dao.impl;

import com.trainings.dao.utils.PersistenceUtils;

import com.trainings.employees.dao.UserDao;
import com.trainings.employees.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserDAOJpa implements UserDao {
    EntityManagerFactory emf = PersistenceUtils.getInstance().getEmf();

    @Override
    public List<User> findAll() {

        EntityManager em = null;
        List<User> resultList = null;

        try{
            em = PersistenceUtils.getInstance().getEmf().createEntityManager();
            TypedQuery<User> query = em.createQuery("FROM User ", User.class);
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
    public User find(Integer id) {
        EntityManager em = emf.createEntityManager();
        User c = em.find(User.class, id);
        em.close();
        return c;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        User c = em.find(User.class, id);
        em.remove(c);
        em.close();
    }
}
