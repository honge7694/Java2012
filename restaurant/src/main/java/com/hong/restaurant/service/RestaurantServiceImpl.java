package com.hong.restaurant.service;

import com.hong.restaurant.dto.PageRequestDTO;
import com.hong.restaurant.dto.PageResultDTO;
import com.hong.restaurant.dto.RestaurantDTO;
import com.hong.restaurant.entity.Restaurant;
import com.hong.restaurant.entity.RestaurantImage;
import com.hong.restaurant.repository.RestaurantImageRepository;
import com.hong.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Function;

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

    @Override
    public PageResultDTO<RestaurantDTO, Object[]> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("pno").descending());

        Page<Object[]> result = restaurantRepository.getListPage(pageable);

        Function<Object[], RestaurantDTO> fn = (arr -> entitiesToDTO(
                (Restaurant)arr[0],
                (List<RestaurantImage>)(Arrays.asList((RestaurantImage)arr[1]))
        ));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public RestaurantDTO getRestaurant(Long pno) {

        List<Object[]> result = restaurantRepository.getRestaurantWithAll(pno);

        Restaurant restaurant = (Restaurant) result.get(0)[0];

        List<RestaurantImage> restaurantImageList = new ArrayList<>(); // 영화의 이미지

        result.forEach(arr -> {
            RestaurantImage restaurantImage = (RestaurantImage)arr[1];
            restaurantImageList.add(restaurantImage);
        });

        return entitiesToDTO(restaurant, restaurantImageList);

    }

    @Override
    public void remove(Long pno) {
        restaurantRepository.deleteById(pno);
    }

    @Override
    public void modify(RestaurantDTO restaurantDTO) {
        Optional<Restaurant> result = restaurantRepository.findById(restaurantDTO.getPno());

        if(result.isPresent()){
            Restaurant entity = result.get();

            entity.changePname(restaurantDTO.getPname());
            entity.changePcost(restaurantDTO.getPcost());

            restaurantRepository.save(entity);
        }


    }
}
