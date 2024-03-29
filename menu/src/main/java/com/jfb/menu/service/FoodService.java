package com.jfb.menu.service;

import com.jfb.menu.entity.Food;
import com.jfb.menu.entity.FoodRequest;
import com.jfb.menu.entity.FoodRequestRecord;
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

    public FoodRequestRecord insert(FoodRequest request) {
        Food entity = new Food();
        copyRecordToEntity(request, entity);
        entity = repository.save(entity);
        return new FoodRequestRecord(entity);
    }

    private void copyRecordToEntity(FoodRequest record, Food entity) {
        entity.setTitle(record.title());
        entity.setImage(record.image());
        entity.setPrice(record.price());
    }
}
