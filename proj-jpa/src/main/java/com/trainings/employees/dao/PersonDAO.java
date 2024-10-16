package com.trainings.employees.dao;

import com.trainings.dao.GenericDAO;
import com.trainings.employees.model.Person;
import com.trainings.employees.model.User;

import java.util.List;

public interface PersonDAO extends GenericDAO<Integer, Person> {

    List<Person> getAllPersonWithUserExcluded();

}
