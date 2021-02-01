package com.swcodingschool.Lesson242;

import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}

// Spring automatically implements this repository interface in a bean 
// that has the same name (with a change in the case — it is called userRepository).

// now you can create a controller like MainController.java