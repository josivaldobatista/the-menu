package com.jfb.menu.Controller;

import com.jfb.menu.entity.FoodRequest;
import com.jfb.menu.entity.FoodRequestRecord;
import com.jfb.menu.entity.FoodResponse;
import com.jfb.menu.repository.FoodRepository;
import com.jfb.menu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @Autowired
    private FoodRepository repository;

    @PostMapping
    public ResponseEntity<FoodRequestRecord> insert(@RequestBody FoodRequest request) {
        FoodRequestRecord foodRequest = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(foodRequest.entity().getId()).toUri();
        return ResponseEntity.created(uri).body(foodRequest);
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Page<FoodResponse>> findAllPaged(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "title") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<FoodResponse> list = service.findAllPaged(pageRequest);

        return ResponseEntity.ok().body(list);
    }
}
