package com.hits.superduperquizbackend.converter;

import com.hits.superduperquizbackend.DTO.quiz.QuestionDTO;
import com.hits.superduperquizbackend.DTO.quiz.QuizDTO;
import com.hits.superduperquizbackend.entity.QuizEntity;

import java.util.ArrayList;

public class QuizConverter {
    public static QuizDTO entityToDTO(QuizEntity entity) {
        var questions = new ArrayList<QuestionDTO>();
        for (var question : entity.getQuestions()) {
            questions.add(QuestionConverter.entityToDTO(question));
        }

        return new QuizDTO (
                entity.getId(),
                entity.getName(),
                entity.getAuthor().getUsername(),
                entity.getDescription(),
                entity.getDifficult(),
                entity.getCategory().getName(),
                questions);
    }
}
