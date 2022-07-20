package com.sparta.delivery.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@ToString(exclude = "order")
@Getter
@Entity
public class OrderFood {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int quantity;

    protected OrderFood() {
    }

    public OrderFood(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }
}
