package com.jfb.menu.service;

import com.jfb.menu.entity.Food;
import com.jfb.menu.entity.FoodRequest;
import com.jfb.menu.entity.FoodResponse;
import com.jfb.menu.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    @Transactional(readOnly = true)
    public Page<FoodResponse> findAllPaged(PageRequest pageRequest) {
        Page<Food> page = repository.findAll(pageRequest);
        return page.map(FoodResponse::new);
    }

    public FoodRequest insert(FoodRequest request) {
        Food entity = new Food();
        copyDtoToEntity(request, entity);
        entity = repository.save(entity);
        return new FoodRequest(entity);
    }

    private void copyDtoToEntity(FoodRequest dto, Food entity) {
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        entity.setPrice(dto.getPrice());
    }
}
