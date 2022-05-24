package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity, String> {
}
