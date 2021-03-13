package com.mars.exercise.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mars.exercise.model.Person;
import com.mars.exercise.repository.PersonRepository;

public class TestPersonService {

	@InjectMocks
	PersonServiceImpl personService;
	
	@Mock
    PersonRepository personRepository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
       
    }
	
	@Test
	public void test() {
		System.out.println("test execution");
		assertTrue(true);
	}
	

	@Test
	public void findAll() {
		List<Person> list  = new ArrayList<Person>();
		Person person = new Person();
		person.setFirstName("Hareesh");
		person.setSurname("Billa");
		person.setId(101L);
		list.add(person);
		
		when(personRepository.findAll()).thenReturn(list);
		assertEquals(personService.getAllPersons().size(),1);
		verify(personRepository, times(1)).findAll();		
	}

	@Test
	public void getPersonById() {
		Person person = new Person();
		person.setFirstName("Hareesh");
		person.setSurname("Billa");
		person.setId(101L);
		
		when(personRepository.getOne(101L)).thenReturn(person);		
		Person personRep = personService.getPersonById(101L);
		assertEquals(personRep.getFirstName(),"Hareesh");
		assertEquals(personRep.getSurname(),"Billa");
		
	}
	
	@Test
	public void createNewPerson() {
		Person person = new Person();
		person.setFirstName("Hareesh");
		person.setSurname("Billa");
		person.setId(101L);
		
		when(personRepository.save(person)).thenReturn(person);		
		Person personRep = personService.createNewPerson(person);
		assertEquals(personRep.getFirstName(),"Hareesh");
		assertEquals(personRep.getSurname(),"Billa");
		verify(personRepository, times(1)).save(person);
	}
	
	@Test
	public void savePerson() {
		Person person = new Person();
		person.setFirstName("Hareesh");
		person.setSurname("Billa");
		person.setId(101L);
		
		when(personRepository.save(person)).thenReturn(person);		
		Person personRep = personService.savePerson(101L,person);
		assertEquals(personRep.getFirstName(),"Hareesh");
		assertEquals(personRep.getSurname(),"Billa");
		verify(personRepository, times(1)).save(person);
	}

	@Test
	public void countPersons() {
		List<Person> list  = new ArrayList<Person>();
		Person person = new Person();
		person.setFirstName("Hareesh");
		person.setSurname("Billa");
		person.setId(101L);
		list.add(person);
		
		when(personRepository.findAll()).thenReturn(list);
		assertEquals(personService.countPersons(),1);
		verify(personRepository, times(1)).findAll();
	}

	@Test
	public void deletePersonById() {
		Person person = new Person();
		person.setFirstName("Hareesh");
		person.setSurname("Billa");
		person.setId(101L);
			
		personService.deletePersonById(101L);
		verify(personRepository, times(1)).deleteById(101L);
	}
	
}
