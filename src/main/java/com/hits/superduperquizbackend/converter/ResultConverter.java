package com.hits.superduperquizbackend.converter;

import com.hits.superduperquizbackend.DTO.result.CreateResultDTO;
import com.hits.superduperquizbackend.DTO.result.ResultDTO;
import com.hits.superduperquizbackend.entity.QuizEntity;
import com.hits.superduperquizbackend.entity.ResultEntity;
import com.hits.superduperquizbackend.entity.UserEntity;

import java.util.UUID;

public class ResultConverter {
    public static ResultEntity DTOToEntity(CreateResultDTO dto,
                                           UserEntity author,
                                           QuizEntity quiz) {
        return new ResultEntity(
                UUID.randomUUID().toString(),
                dto.getScore(),
                author, quiz
        );
    }

    public static ResultDTO entityToDTO(ResultEntity entity) {
        return new ResultDTO(
                entity.getId(),
                entity.getAuthor().getId(),
                entity.getQuiz().getId(),
                entity.getQuantity());
    }
}
