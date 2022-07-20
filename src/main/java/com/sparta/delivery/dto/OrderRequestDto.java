package com.sparta.delivery.dto;

import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.OrderFood;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderRequestDto {

    private Long restaurantId;

    private List<OrderFoodDto> foods;

}
