package com.swcodingschool.Lesson251_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer>
        
          findAll() {
        return jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers",
                (rs, rowNum) -> new Customer(rs.getLong("id"),
                rs.getString("first_name"), rs.getString("last_name")));
    }

    public void update(Customer customer) {
        jdbcTemplate.update(
            "UPDATE customers SET first_name=?, last_name=? WHERE id=?",
            customer.getFirstName(), customer.getLastName(), customer.getId());
    }

}