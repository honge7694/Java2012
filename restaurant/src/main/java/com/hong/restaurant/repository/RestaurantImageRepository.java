package com.hong.restaurant.repository;

import com.hong.restaurant.entity.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Long> {
}
