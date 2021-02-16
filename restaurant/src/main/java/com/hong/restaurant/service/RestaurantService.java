package com.hong.restaurant.service;

import com.hong.restaurant.dto.RestaurantDTO;
import com.hong.restaurant.entity.Restaurant;

public interface RestaurantService {
    Long register1(RestaurantDTO dto);

    // service에서 repository로 갈 때 dto -> entity로 변환해야한다.
    default Restaurant dtoToEntity(RestaurantDTO dto){
        Restaurant entity = Restaurant.builder()
                .pno(dto.getPno())
                .pname(dto.getPname())
                .pcost(dto.getPcost())
                .fileName(dto.getFileName())
                .oriFileName(dto.getOriFileName())
                .filePath(dto.getFilePath())
                .build();

        return entity;
    }
}
