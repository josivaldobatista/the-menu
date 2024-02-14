package com.jfb.menu.Controller;

import com.jfb.menu.entity.Food;
import com.jfb.menu.entity.FoodRequest;
import com.jfb.menu.entity.FoodResponse;
import com.jfb.menu.repository.FoodRepository;
import com.jfb.menu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @Autowired
    private FoodRepository repository;

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void saveFood(@RequestBody FoodRequest data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<FoodResponse>> getAll() {

        List<FoodResponse> foodList = service
                .findAll()
                .stream()
                .map(FoodResponse::new)
                .toList();
        return ResponseEntity.ok().body(foodList);
    }
}
