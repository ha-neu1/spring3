package com.sparta.delivery.controller;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import com.sparta.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    //음식점 등록
    @PostMapping("/restaurant/register")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody RestaurantRequestDto requestDto) {
        Restaurant restaurant = restaurantService.registerRestaurant(requestDto);
        return ResponseEntity.ok().body(restaurant);
    }

    //음식점 조회
    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return ResponseEntity.ok().body(restaurantList);
    }
}
