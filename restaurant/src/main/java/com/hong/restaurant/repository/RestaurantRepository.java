package com.hong.restaurant.repository;

import com.hong.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, QuerydslPredicateExecutor<Restaurant> {
}
