package com.sparta.delivery.controller;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;
    private final FoodRepository foodRepository;

    //음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public ResponseEntity<Food> registerFood(@PathVariable Restaurant restaurantId, @RequestBody List<FoodRequestDto> foodRequestDto) {
        foodService.registerFood(restaurantId, foodRequestDto);
        return ResponseEntity.ok().body(null);
    }

    //메뉴판 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public ResponseEntity<List<Food>> getFoods(@PathVariable Restaurant restaurantId) {
        List<Food> foodList = foodRepository.findAllByRestaurant(restaurantId);
        return ResponseEntity.ok().body(foodList);
    }
}
