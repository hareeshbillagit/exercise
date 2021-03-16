package com.mars.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.LazyInitializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.google.gson.Gson;
import com.mars.exercise.model.Person;
import com.mars.exercise.service.PersonService;

@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {
	 private static final Logger log = LoggerFactory.getLogger(ExerciseApplication.class);
	  @Autowired
	  private PersonService personService;
	  
	  public static void main(String[] args) {
	    SpringApplication.run(ExerciseApplication.class, args);
	  }
	  
	  public void run(String... args) throws Exception {
	      try(BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
	        log.info("Application Started!!");
	        
	        log.info("Please provide valid actions(insert/update/delete/count/all/exit):");
	        String line = "";
	        while (((line = buffReader.readLine()) != null) && (!line.equals("exit"))) {
	          switch (line) {
		          case "insert": 
		            insertPerson(buffReader);
		            break;
		          case "update": 
		            updatePerson(buffReader);
		            break;
		          case "delete": 
		            deletePerson(buffReader);
		            break;
		          case "count": 
		            log.info("All Persons count:{}", Integer.valueOf(this.personService.countPersons()));
		            break;
		          case "all": 
		            log.info("All Persons List:{}", this.personService.getAllPersons());
		            break;
		          default: 
		            log.info("Invalid input, pease try");
	          }
	          log.info("Please provide valid actions(insert/update/delete/count/all/exit):");
	        }
	        log.info("exit from application!!");
	      } catch (Exception exception) {
		      log.error("Exception Occured while processing:" + exception);
		  }
	  }
	    
	  
	  
	  void insertPerson(BufferedReader buffReader) throws IOException {
	    log.info("Please enter details in JSON format:");
	    String personString = buffReader.readLine();
	    log.info("insert JSON String:{}", personString);
	    try {
	      Person person = (Person)new Gson().fromJson(personString, Person.class);
	      Person personPersisted = this.personService.createNewPerson(person);
	      log.info("new entry added successfully:{}", personPersisted);
	    } catch (Exception exception) {
	      log.error("Exception Occured:" + exception);
	    }
	  }
	  
	  
	  void updatePerson(BufferedReader buffReader) throws IOException {
	    log.info("Please enter details in JSON format:");
	    String personString = buffReader.readLine();
	    log.info("insert JSON String:{}", personString);
	    try {
	      Person person = (Person)new Gson().fromJson(personString, Person.class);
	      log.info("person details will be updated with :{}", person);
	      Person personUpdated = this.personService.savePerson(person.getId(), person);
	      log.info("person details updated successfully:{}", personUpdated);
	    }
	    catch (InvalidDataAccessApiUsageException exception) {
	      log.error("Invalid input!!");
	      log.error("Exception Occured:" + exception);
	    } catch (LazyInitializationException exception) {
	      log.error("Invalid input/object not exists!!");
	      log.error("Exception Occured:" + exception);
	    } catch (Exception exception) {
	      log.error("Exception Occured:" + exception);
	    }
	  }
	  
	  
	  void deletePerson(BufferedReader buffReader) throws IOException {
	    log.info("Please enter Person Id in numeric:");
	    String personId = buffReader.readLine();
	    try {
	    	Person person = this.personService.getPersonById(Long.valueOf(personId));
	      if (person != null) {
	    	log.info("person id {} will be deleted:{}",personId, person);
	        this.personService.deletePersonById(Long.valueOf(personId));
	      }
	    } catch (NumberFormatException exception)	{
	      log.error("Invalid input");
	      log.error("Exception Occured:" + exception);
	    } catch (Exception exception) {
	      log.error("Exception Occured:" + exception);
	    }
	  }
}
