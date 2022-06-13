package com.hits.superduperquizbackend.converter;

import com.hits.superduperquizbackend.DTO.quiz.AnswerDTO;
import com.hits.superduperquizbackend.entity.AnswerOptionEntity;

public class AnswerConverter {
    public static AnswerDTO entityToDTO(AnswerOptionEntity entity) {
        return new AnswerDTO(
                entity.getId(),
                entity.getText(),
                entity.getIsRight()
        );
    }
}
