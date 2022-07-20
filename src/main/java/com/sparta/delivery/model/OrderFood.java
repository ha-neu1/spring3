package com.sparta.delivery.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderFood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int quantity;

    public OrderFood() {

    }

    public OrderFood(Food food, Order order, int quantity) {
        this.food = food;
        this.order = order;
        this.quantity = quantity;
    }


}
