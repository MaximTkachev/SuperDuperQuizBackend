package com.hits.superduperquizbackend.converter;

import com.hits.superduperquizbackend.DTO.quiz.CreateQuizDTO;
import com.hits.superduperquizbackend.DTO.quiz.QuizDTO;
import com.hits.superduperquizbackend.entity.QuizEntity;

import java.util.HashSet;

public class QuizConverter {
    public static QuizDTO entityToDTO(QuizEntity entity) {
        return new QuizDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDifficult(),
                entity.getCategory().getId()
        );
    }
}
