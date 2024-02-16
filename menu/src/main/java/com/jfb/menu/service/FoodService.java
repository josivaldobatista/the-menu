package com.jfb.menu.service;

import com.jfb.menu.entity.Food;
import com.jfb.menu.entity.FoodResponse;
import com.jfb.menu.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    @Transactional(readOnly = true)
    public Page<FoodResponse> findAll(PageRequest pageRequest) {
        Page<Food> page = repository.findAll(pageRequest);
        return page.map(x -> new FoodResponse(x));
    }

    public void saveFood() {

    }
}
