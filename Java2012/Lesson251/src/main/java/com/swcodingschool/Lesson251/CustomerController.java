package com.swcodingschool.Lesson251;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value ="/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping(value = "/")
	@ResponseBody
	public List<Customer> list(Customer customer){
		customerRepository.save(customer);
	    return customerRepository.findAll();
	}
}
