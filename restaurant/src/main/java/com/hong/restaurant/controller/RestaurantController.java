package com.hong.restaurant.controller;



import com.hong.restaurant.dto.PageRequestDTO;
import com.hong.restaurant.dto.PageResultDTO;
import com.hong.restaurant.dto.RestaurantDTO;
import com.hong.restaurant.entity.Restaurant;
import com.hong.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String list(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............");

        model.addAttribute("result", restaurantService.getList(pageRequestDTO));

        return "/restaurant/list";
    }

    @GetMapping("/register")
    public String register(){

        return "/restaurant/register";
    }

    @PostMapping("/register")
    public String uploadFile(RestaurantDTO restaurantDTO, RedirectAttributes redirectAttributes){
        log.info("restaurantDTO: " + restaurantDTO );

        Long pno = restaurantService.register(restaurantDTO);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/restaurant/list";

    }

    @GetMapping({"/read", "/modify"})
    public void read(long pno, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model){

        log.info("pno :" + pno);

        RestaurantDTO restaurantDTO = restaurantService.getRestaurant(pno);

        model.addAttribute("dto", restaurantDTO);
    }

    @PostMapping("/modify")


    @PostMapping("/remove")
    public String remove(long pno, RedirectAttributes redirectAttributes){

        log.info("pno" + pno);

        restaurantService.remove(pno);

        redirectAttributes.addFlashAttribute("msg" + pno);

        return "redirect:/restaurant/list";
    }

}
