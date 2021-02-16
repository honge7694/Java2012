package com.hong.restaurant.service;

import com.hong.restaurant.dto.RestaurantDTO;
import com.hong.restaurant.dto.RestaurantImageDTO;
import com.hong.restaurant.entity.Restaurant;
import com.hong.restaurant.entity.RestaurantImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface RestaurantService {
    Long register(RestaurantDTO restaurantDTO);

    // service에서 repository로 갈 때 dto -> entity로 변환해야한다.
    default Map<String, Object> dtoToEntity(RestaurantDTO restaurantDTO){

        Map<String, Object> entityMap = new HashMap<>();

        Restaurant restaurant = Restaurant.builder()
                .pno(restaurantDTO.getPno())
                .pname(restaurantDTO.getPname())
                .pcost(restaurantDTO.getPcost())
                .build();

       entityMap.put("restaurant", restaurant);

       List<RestaurantImageDTO> imageDTOList = restaurantDTO.getImageDTOList();

       // RestaurantDTO 처리
       if(imageDTOList != null && imageDTOList.size() > 0){
         List<RestaurantImage> restaurantImageList = imageDTOList.stream().map(restaurantImageDTO -> {

             RestaurantImage restaurantImage = RestaurantImage.builder()
                     .path(restaurantImageDTO.getPath())
                     .imgName(restaurantImageDTO.getImgName())
                     .uuid(restaurantImageDTO.getUuid())
                     .restaurant(restaurant)
                     .build();

             return restaurantImage;
         }).collect(Collectors.toList());

         entityMap.put("imgList", restaurantImageList);
       }
       return entityMap;
    }
}
