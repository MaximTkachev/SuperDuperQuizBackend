package com.hits.superduperquizbackend.service;

import com.hits.superduperquizbackend.DTO.category.CategoryDTO;
import com.hits.superduperquizbackend.DTO.category.CreateCategoryDTO;
import com.hits.superduperquizbackend.DTO.category.EditCategoryDto;
import com.hits.superduperquizbackend.entity.CategoryEntity;
import com.hits.superduperquizbackend.exception.NotFoundException;
import com.hits.superduperquizbackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public CategoryDTO createCategory(CreateCategoryDTO dto) {
        var entity = new CategoryEntity(dto);
        var savedEntity = categoryRepository.save(entity);
        return new CategoryDTO(savedEntity.getId(), savedEntity.getName());
    }

    @Transactional
    public CategoryDTO editCategory(EditCategoryDto dto, String id) {
        var entity = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Категория не найдена"));
        entity.setName(dto.getName());
        return new CategoryDTO(entity.getId(), entity.getName());
    }
}
