package com.swcodingschool.Lesson241;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    /*
     * The Person object has a first name and a last name. (There is also an ID
     * object that is configured to be automatically generated, so you need not deal
     * with that.)
     * Next, we need to create a simple repository, as PersonRepository.java
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}