package com.hong.restaurant.service;

import com.hong.restaurant.dto.RestaurantDTO;
import com.hong.restaurant.entity.Restaurant;
import com.hong.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository repository;

    @Override
    public Long register1(RestaurantDTO dto) {

        log.info("DTO Register -------------------");
        log.info(dto);

        Restaurant entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getPno();
    }
}
