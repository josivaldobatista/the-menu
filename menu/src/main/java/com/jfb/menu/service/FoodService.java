package com.jfb.menu.service;

import com.jfb.menu.entity.Food;
import com.jfb.menu.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public List<Food> findAll() {
        return repository.findAll();
    }
}
