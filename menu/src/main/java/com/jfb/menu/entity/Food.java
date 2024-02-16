package com.jfb.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    public Food(FoodRequest data) {
        this.image = data.getImage();
        this.title = data.getTitle();
        this.price = data.getPrice();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Double price;
}
