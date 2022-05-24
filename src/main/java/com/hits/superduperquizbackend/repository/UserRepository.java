package com.hits.superduperquizbackend.repository;

import com.hits.superduperquizbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
