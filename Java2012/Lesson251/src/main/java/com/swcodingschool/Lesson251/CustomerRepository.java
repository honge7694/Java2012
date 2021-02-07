package com.swcodingschool.Lesson251;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Lesson242 UserRepository
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
	
}
