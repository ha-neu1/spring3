package com.sparta.delivery.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderFoodResponseDto {

    private String restaurantName;
    private List<OrderFoodResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;
}
