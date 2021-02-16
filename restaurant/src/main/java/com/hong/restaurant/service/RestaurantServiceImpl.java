package com.hong.restaurant.service;

import com.hong.restaurant.dto.RestaurantDTO;
import com.hong.restaurant.entity.Restaurant;
import com.hong.restaurant.entity.RestaurantImage;
import com.hong.restaurant.repository.RestaurantImageRepository;
import com.hong.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    private final RestaurantImageRepository imageRepository;

    @Transactional
    @Override
    public Long register(RestaurantDTO restaurantDTO) {

        Map<String, Object> entityMap = dtoToEntity(restaurantDTO);
        Restaurant restaurant = (Restaurant) entityMap.get("restaurant");
        List<RestaurantImage> restaurantImageList = (List<RestaurantImage>) entityMap.get("imgList");

        restaurantRepository.save(restaurant);

        restaurantImageList.forEach(restaurantImage -> {
            imageRepository.save(restaurantImage);
        });

        return restaurant.getPno();
    }
}
