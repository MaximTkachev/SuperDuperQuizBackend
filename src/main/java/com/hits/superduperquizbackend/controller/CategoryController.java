package com.hits.superduperquizbackend.controller;

import com.hits.superduperquizbackend.DTO.category.CategoryDTO;
import com.hits.superduperquizbackend.DTO.category.CreateCategoryDTO;
import com.hits.superduperquizbackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryDTO createCategory(@Validated @RequestBody CreateCategoryDTO dto) {
        return categoryService.createCategory(dto);
    }
}
