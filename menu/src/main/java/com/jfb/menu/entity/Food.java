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
        this.image = data.image();
        this.title = data.title();
        this.price = data.price();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Double price;
}
