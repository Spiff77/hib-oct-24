package com.trainings.employees.dao.impl;

import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.employees.dao.ComputerDAO;
import com.trainings.employees.dao.DepatmentDAO;
import com.trainings.employees.model.Computer;
import com.trainings.employees.model.ComputerId;
import com.trainings.employees.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DepartmentDAOJpa implements DepatmentDAO {

    EntityManagerFactory emf = PersistenceUtils.getInstance().getEmf();


    @Override
    public List<Department> findAll() {

        EntityManager em = null;
        List<Department> resultList = null;

        try{
            em = PersistenceUtils.getInstance().getEmf().createEntityManager();
            TypedQuery<Department> query = em.createQuery("FROM Department ", Department.class);
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
    public Department find(Integer id) {
        EntityManager em = emf.createEntityManager();
        Department c = em.find(Department.class, id);
        em.close();
        return c;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        Department c = em.find(Department.class, id);
        em.remove(c);
        em.close();
    }
}
