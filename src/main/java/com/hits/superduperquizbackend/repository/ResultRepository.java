package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<ResultEntity, String> {
}
