package com.trainings.dao;

import java.util.List;

public interface GenericDAO<K,T>{
    List<T> findAll();
    T find(K id);
    void delete(K id);
}
