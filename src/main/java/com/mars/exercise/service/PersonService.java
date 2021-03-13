package com.mars.exercise.service;

import java.util.List;
import com.mars.exercise.model.Person;

public abstract interface PersonService{
	
  public abstract List<Person> getAllPersons();
  
  public abstract Person getPersonById(Long paramLong);
  
  public abstract Person createNewPerson(Person paramPerson);
  
  public abstract Person savePerson(Long paramLong, Person paramPerson);
  
  public abstract int countPersons();
  
  public abstract void deletePersonById(Long paramLong);
}
