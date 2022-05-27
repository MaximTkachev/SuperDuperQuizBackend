package com.hits.superduperquizbackend.service;

import com.hits.superduperquizbackend.DTO.category.CategoryDTO;
import com.hits.superduperquizbackend.DTO.category.CreateCategoryDTO;
import com.hits.superduperquizbackend.entity.CategoryEntity;
import com.hits.superduperquizbackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CreateCategoryDTO dto) {
        var entity = new CategoryEntity(dto);
        var savedEntity = categoryRepository.save(entity);
        return new CategoryDTO(savedEntity.getId(), savedEntity.getName());
    }
}
