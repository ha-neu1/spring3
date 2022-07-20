package com.sparta.delivery.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {

    private String restaurantName;
    private List<OrderFoodResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;
}
