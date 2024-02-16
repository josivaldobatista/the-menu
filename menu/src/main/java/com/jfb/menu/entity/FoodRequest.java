package com.jfb.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequest {

    private Long id;
    private String title;
    private String image;
    private Double price;

    public FoodRequest(Long id, Food entity) {
        this.id = id;
        title = entity.getTitle();
        image = entity.getImage();
        price = entity.getPrice();
    }

    public FoodRequest(Food entity) {
        id = entity.getId();
        title = entity.getTitle();
        image = entity.getImage();
        price = entity.getPrice();
    }
}
