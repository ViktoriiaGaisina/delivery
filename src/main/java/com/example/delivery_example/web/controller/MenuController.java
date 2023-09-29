package com.example.delivery_example.web.controller;

import com.example.delivery_example.web.dto.DishDTO;
import com.example.delivery_example.web.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Menu s informacemi o jídlech")
public class MenuController {
    private final DishService dishService;

    @Autowired
    public MenuController(@Qualifier("dishServiceImpl") DishService dishService) {
        this.dishService = dishService;
    }

    @ApiOperation("Seznam všech jídel s postránkovým zobrazením")
    @GetMapping("/menu-info/page/{pageNo}")
    public ResponseEntity<Page<DishDTO>> getDishPaginated(@PathVariable int pageNo) {
        int pageSize = 2;
        Page<DishDTO> page = dishService.getDishByPage(pageNo, pageSize);
        return ResponseEntity.ok(page);
    }
}
