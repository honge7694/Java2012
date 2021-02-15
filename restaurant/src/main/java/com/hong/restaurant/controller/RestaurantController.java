package com.hong.restaurant.controller;

import com.hong.restaurant.service.RestaurantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")
@Log4j2
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping({"/", "/list"})
    public String list(){

        log.info("list............");

        return "/restaurant/list";
    }

    @GetMapping("/register")
    public String insert(){

        return "/restaurant/register";
    }
}
