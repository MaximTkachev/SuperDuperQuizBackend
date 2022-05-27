package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}
