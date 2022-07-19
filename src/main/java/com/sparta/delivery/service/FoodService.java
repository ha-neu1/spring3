package com.sparta.delivery.service;


import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FoodService {
    private final FoodRepository foodRepository;

    @Transactional
    public void registerFood(Restaurant restaurantId, List<FoodRequestDto> foodRequestDto) {
        HashSet<String> hashSet = new HashSet<>();
        for (FoodRequestDto foodRequestDtoList : foodRequestDto) {
            hashSet.add(foodRequestDtoList.getName());
        }

        if (hashSet.size() != foodRequestDto.size())
            throw new IllegalArgumentException("등록된 음식 이름입니다.");
        if (validCheck(restaurantId, foodRequestDto))
            throw new IllegalArgumentException("이미 존재하는 음식 이름입니다.");


        for (FoodRequestDto foodRequestDtoList : foodRequestDto) {
            int price = foodRequestDtoList.getPrice();

            if (price < 100 || price > 1000000) {
                throw new IllegalArgumentException("100원 ~ 1,000,000원만 입력 가능합니다.");
            }
            if (price % 100 != 0) {
                throw new IllegalArgumentException("100원 단위로 입력해 주세요.");
            }
            Food food = new Food(restaurantId, foodRequestDtoList);
            foodRepository.save(food);
        }
    }

    public boolean validCheck(Restaurant restaurantId, List<FoodRequestDto> foodRequestDto) {
        for (FoodRequestDto foodRequestDtoList : foodRequestDto) {
            if (foodRepository.existsByNameAndRestaurant(foodRequestDtoList.getName(), restaurantId))
                return true;
        }
        return false;
    }
}
