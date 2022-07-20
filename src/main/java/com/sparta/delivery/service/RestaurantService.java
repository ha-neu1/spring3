package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant registerRestaurant(RestaurantRequestDto restaurantDto) {
        int minOrderPrice = restaurantDto.getMinOrderPrice();
        int deliveryFee = restaurantDto.getDeliveryFee();

        if (minOrderPrice < 1000 || minOrderPrice > 100000) {
            throw new IllegalArgumentException("1,000원 ~ 100,000원만 입력 가능합니다.");
        }
        if (minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        }
        if (deliveryFee < 0 || deliveryFee > 10000 ) {
            throw new IllegalArgumentException("0원 ~ 10,000원만 입력 가능합니다.");
        }
        if (deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("500원 단위로 입력해주세요.");
        }
        Restaurant restaurant = new Restaurant(restaurantDto);
        return restaurantRepository.save(restaurant);
    }

}
