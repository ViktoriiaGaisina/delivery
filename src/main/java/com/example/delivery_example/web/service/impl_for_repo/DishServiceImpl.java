package com.example.delivery_example.web.service.impl_for_repo;

import com.example.delivery_example.store.entity.DishEntity;
import com.example.delivery_example.store.repository.DishRepository;
import com.example.delivery_example.web.dto.DishDTO;
import com.example.delivery_example.web.dto.mapper.DishMapper;
import com.example.delivery_example.web.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Autowired
    public DishServiceImpl(com.example.delivery_example.store.repository.DishRepository dishRepository, @Qualifier("dishMapperImpl") DishMapper dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }

    @Override
    public DishEntity getDishEntityById(long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public DishDTO getDishByName(String name) {
        return dishRepository.findDishEntitiesByName(name)
                .map(entity -> dishMapper.toDto(entity))
                .orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public Page<DishDTO> getDishByPage(int pageNo, int pageSize ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DishEntity> all = dishRepository.findAll(pageable);
        return all.map(dishMapper::toDto);
    }
}

