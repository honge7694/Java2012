package com.hong.restaurant.controller;



import com.hong.restaurant.dto.RestaurantDTO;
import com.hong.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
@RequestMapping("/restaurant")
@Log4j2
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping({"/", "/list"})
    public String list(){

        log.info("list............");

        return "/restaurant/list";
    }

    @GetMapping("/register")
    public String register(){

        return "/restaurant/register";
    }

    @PostMapping("/register")
    public String uploadFile(RestaurantDTO restaurantDTO, RedirectAttributes redirectAttributes){
        log.info("restaurantDTO: " + restaurantDTO );

        Long mno =restaurantService.register(restaurantDTO);

        redirectAttributes.addFlashAttribute("msg", mno);

        return "redirect:/restaurant/list";

    }
    

}
