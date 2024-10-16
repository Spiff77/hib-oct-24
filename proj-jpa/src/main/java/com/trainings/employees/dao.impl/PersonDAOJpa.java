package com.trainings.employees.dao.impl;

import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.employees.dao.PersonDAO;
import com.trainings.employees.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonDAOJpa implements PersonDAO {
    EntityManagerFactory emf = PersistenceUtils.getInstance().getEmf();

    @Override
    public List<Person> findAll() {

        EntityManager em = null;
        List<Person> resultList = null;

        try{
            em = PersistenceUtils.getInstance().getEmf().createEntityManager();
            TypedQuery<Person> query = em.createQuery("FROM Person ", Person.class);
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
    public Person find(Integer id) {
        EntityManager em = emf.createEntityManager();
        Person c = em.find(Person.class, id);
        em.close();
        return c;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        Person c = em.find(Person.class, id);
        em.remove(c);
        em.close();
    }

    @Override
    public List<Person> getAllPersonWithUserExcluded() {
        EntityManager em = null;
        List<Person> resultList = null;

        try{
            em = PersistenceUtils.getInstance().getEmf().createEntityManager();
            TypedQuery<Person> query = em.createQuery("FROM Person p WHERE TYPE(p) != User", Person.class);
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
}
