package com.mars.exercise.repository;

import com.mars.exercise.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface PersonRepository  extends JpaRepository<Person, Long> {
	
	
  //public abstract Person getPersonByFirstNameAndSurname(String paramString1, String paramString2);
}
