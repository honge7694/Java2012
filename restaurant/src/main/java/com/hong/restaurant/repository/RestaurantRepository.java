package com.hong.restaurant.repository;

import com.hong.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, QuerydslPredicateExecutor<Restaurant> {

    @Query("select r, ri from Restaurant r " +
            "left outer join RestaurantImage ri on ri.restaurant = r group by r ")
    Page<Object[]> getListPage(Pageable pageable);

    @Query("select r, ri from Restaurant r " +
            "left outer join RestaurantImage ri on ri.restaurant = r" +
            " where r.pno = :pno group by ri")
    List<Object[]> getRestaurantWithAll(Long pno);
}
