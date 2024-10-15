package com.trainings.dao.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtils {

    private static PersistenceUtils instance;
    private static final EntityManagerFactory emf = buildEmf();


    private PersistenceUtils() {
    }

    public static PersistenceUtils getInstance(){
        if(instance == null){
            instance = new PersistenceUtils();
        }
        return instance;
    }

    public EntityManagerFactory getEmf(){
        return emf;
    }


    private static EntityManagerFactory buildEmf(){
        return Persistence.createEntityManagerFactory("formation");
    }

    public void shutDown(){
        this.getEmf().close();
    }

}
