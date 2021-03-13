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
	  
	  public static void main(String[] args)
	  {
	    SpringApplication.run(ExerciseApplication.class, args);
	  }
	  
	  public void run(String... args)
	    throws Exception
	  {
	    try
	    {
	      BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));Throwable localThrowable3 = null;
	      try
	      {
	        log.info("Application Started!!");
	        
	        System.out.println("Please provide valid actions(insert/update/delete/count/all/exit):");
	        String line = "";
	        while (((line = buffReader.readLine()) != null) && (!line.equals("exit")))
	        {
	          switch (line)
	          {
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
	            System.out.println("Invalid input, pease try");
	          }
	          System.out.println("Please provide valid actions(insert/update/delete/count/all/exit):");
	        }
	        log.info("exit from application!!");
	      }
	      catch (Throwable localThrowable1)
	      {
	        localThrowable3 = localThrowable1;throw localThrowable1;
	      }
	      finally
	      {
	        if (buffReader != null) {
	          if (localThrowable3 != null) {
	            try
	            {
	              buffReader.close();
	            }
	            catch (Throwable localThrowable2)
	            {
	              localThrowable3.addSuppressed(localThrowable2);
	            }
	          } else {
	            buffReader.close();
	          }
	        }
	      }
	    }
	    catch (Exception exception)
	    {
	      log.error("Exception Occured:" + exception);
	    }
	  }
	  
	  void insertPerson(BufferedReader buffReader)
	    throws IOException
	  {
	    System.out.println("Please enter details in JSON format:");
	    String personString = buffReader.readLine();
	    log.info("insert JSON String:{}", personString);
	    try
	    {
	      Person person = (Person)new Gson().fromJson(personString, Person.class);
	      Person personPersisted = this.personService.createNewPerson(person);
	      log.info("new entry added successfully:{}", personPersisted);
	    }
	    catch (Exception exception)
	    {
	      log.error("Exception Occured:" + exception);
	    }
	  }
	  
	  void updatePerson(BufferedReader buffReader)
	    throws IOException
	  {
	    System.out.println("Please enter details in JSON format:");
	    String personString = buffReader.readLine();
	    log.info("insert JSON String:{}", personString);
	    try
	    {
	      Person person = (Person)new Gson().fromJson(personString, Person.class);
	      Person personUpdated = this.personService.savePerson(person.getId(), person);
	      log.info("person details updated successfully:{}", personUpdated);
	    }
	    catch (InvalidDataAccessApiUsageException exception)
	    {
	      log.error("Invalid input!!");
	      log.error("Exception Occured:" + exception);
	    }
	    catch (LazyInitializationException exception)
	    {
	      log.error("Invalid input/object not exists!!");
	      log.error("Exception Occured:" + exception);
	    }
	    catch (Exception exception)
	    {
	      log.error("Exception Occured:" + exception);
	    }
	  }
	  
	  void deletePerson(BufferedReader buffReader)
	    throws IOException
	  {
	    System.out.println("Please enter Person Id in numeric:");
	    String personId = buffReader.readLine();
	    try
	    {
	      if (this.personService.getPersonById(Long.valueOf(personId)) != null) {
	        this.personService.deletePersonById(Long.valueOf(personId));
	      }
	    }
	    catch (NumberFormatException exception)
	    {
	      log.error("Invalid input");
	      log.error("Exception Occured:" + exception);
	    }
	    catch (Exception exception)
	    {
	      log.error("Exception Occured:" + exception);
	    }
	  }
	}
