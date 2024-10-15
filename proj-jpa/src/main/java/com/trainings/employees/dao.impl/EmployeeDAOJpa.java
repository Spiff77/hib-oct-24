package com.trainings.employees.dao.impl;

import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.employees.dao.DepatmentDAO;
import com.trainings.employees.dao.EmployeeDAO;
import com.trainings.employees.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeDAOJpa implements EmployeeDAO {
    EntityManagerFactory emf = PersistenceUtils.getInstance().getEmf();

    @Override
    public List<Employee> findAll() {

        EntityManager em = null;
        List<Employee> resultList = null;

        try{
            em = PersistenceUtils.getInstance().getEmf().createEntityManager();
            TypedQuery<Employee> query = em.createQuery("FROM Employee ", Employee.class);
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
    public Employee find(Integer id) {
        EntityManager em = emf.createEntityManager();
        Employee c = em.find(Employee.class, id);
        em.close();
        return c;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        Employee c = em.find(Employee.class, id);
        em.remove(c);
        em.close();
    }
}
