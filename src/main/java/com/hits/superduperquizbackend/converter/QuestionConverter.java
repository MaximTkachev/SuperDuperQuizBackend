package com.hits.superduperquizbackend.converter;

import com.hits.superduperquizbackend.DTO.quiz.AnswerDTO;
import com.hits.superduperquizbackend.DTO.quiz.QuestionDTO;
import com.hits.superduperquizbackend.entity.QuestionEntity;

import java.util.ArrayList;

public class QuestionConverter {
    public static QuestionDTO entityToDTO(QuestionEntity entity) {
        var answers = new ArrayList<AnswerDTO>();
        for (var answer : entity.getAnswerOptions()) {
            answers.add(AnswerConverter.entityToDTO(answer));
        }

        return new QuestionDTO(
                entity.getId(),
                entity.getText(),
                answers);
    }
}
