package com.jfb.menu.entity;

public record FoodResponse(
        Long id,
        String title,
        String image,
        Double price
) {
    public FoodResponse(Food food) {
        this(
                food.getId(),
                food.getTitle(),
                food.getImage(),
                food.getPrice());
    }
}
