package com.jfb.menu.Controller;

import com.jfb.menu.entity.Food;
import com.jfb.menu.entity.FoodResponse;
import com.jfb.menu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @GetMapping
    public ResponseEntity<List<FoodResponse>> getAll() {

        List<FoodResponse> foodList = service
                .findAll()
                .stream()
                .map(FoodResponse::new)
                .toList();
        return ResponseEntity.ok().body(foodList);
    }
}
