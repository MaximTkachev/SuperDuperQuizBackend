package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, String> {
}
