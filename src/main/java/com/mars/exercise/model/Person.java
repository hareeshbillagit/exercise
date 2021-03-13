package com.mars.exercise.model;


import com.google.gson.Gson;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID")
  private Long id;
  @Column(name="FIRSTNAME")
  private String firstName;
  @Column(name="SURNAME")
  private String surname;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  public String getSurname()
  {
    return this.surname;
  }
  
  public void setSurname(String surname)
  {
    this.surname = surname;
  }
  
  public String toString()
  {
    return new Gson().toJson(this);
  }
}
