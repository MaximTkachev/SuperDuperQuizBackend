package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.QuizEntity;
import com.hits.superduperquizbackend.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<ResultEntity, String> {

    List<ResultEntity> findTop10ByQuizOrderByQuantityDesc(QuizEntity quiz);
}
