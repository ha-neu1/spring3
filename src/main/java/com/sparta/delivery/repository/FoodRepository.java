package com.sparta.delivery.repository;

import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByNameAndRestaurant(String name, Restaurant Restaurant);
    List<Food> findAllByRestaurant(Restaurant Restaurant);
}
