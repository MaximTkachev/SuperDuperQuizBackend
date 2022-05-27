package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.AnswerOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerOptionRepository extends JpaRepository<AnswerOptionEntity, String> {
}
