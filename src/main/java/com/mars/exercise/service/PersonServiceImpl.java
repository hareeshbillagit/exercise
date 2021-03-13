package com.mars.exercise.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mars.exercise.model.Person;
import com.mars.exercise.repository.PersonRepository;

@Service
public class PersonServiceImpl  implements PersonService {
  

  private PersonRepository personRepository;
  
  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }
  
  public List<Person> getAllPersons()
  {
    return this.personRepository.findAll();
  }
  
  public Person getPersonById(Long id)
  {
    return (Person)this.personRepository.getOne(id);
  }
  
  public Person createNewPerson(Person person)
  {
    return (Person)this.personRepository.save(person);
  }
  
  public Person savePerson(Long id, Person person)
  {
    return (Person)this.personRepository.save(person);
  }
  
  public int countPersons()
  {
    return getAllPersons().size();
  }
  
  public void deletePersonById(Long id)
  {
    this.personRepository.deleteById(id);
  }
}
