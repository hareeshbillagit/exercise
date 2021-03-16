package com.mars.exercise.service;

import java.util.List;
import com.mars.exercise.model.Person;

public abstract interface PersonService{
	
   /**
   * This method method will return 
   * all the person from Person tables
   * 
   */
  public abstract List<Person> getAllPersons();
  
  /**
   * this method will return 
   * a person details from Person tables
   * @param id this parameter denotes the person id
   * will return Person for given person id
   */
  public abstract Person getPersonById(Long paramLong);
  
  /**
   * this method will create or make an entry
   * into Person tables
   * @param person this parameter denotes the person details
   * will return Person of saved record
   */
  public abstract Person createNewPerson(Person paramPerson);
  
  /**
   * this method will save or update an entry
   * into Person tables
   * @param id this parameter denotes the person id
   * @param person this parameter denotes the person details
   * will return Person of saved/updated record
   */
  public abstract Person savePerson(Long paramLong, Person paramPerson);
  
  /**
   * this method will count records in Person tables
   * will return int of persons count
   */
  public abstract int countPersons();
  
  /**
   * this method will deletes an entry
   * from Person tables and returns nothing
   * @param id this parameter denotes the person id
   * 
   */
  public abstract void deletePersonById(Long paramLong);
  
}
