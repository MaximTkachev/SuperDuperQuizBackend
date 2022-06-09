package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.CategoryEntity;
import com.hits.superduperquizbackend.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<QuizEntity, String> {
    List<QuizEntity> findByCategory(CategoryEntity category);
}
