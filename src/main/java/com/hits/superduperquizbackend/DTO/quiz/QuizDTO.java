package com.hits.superduperquizbackend.DTO.quiz;

import com.hits.superduperquizbackend.entity.Difficult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private String id;
    private String name;
    private String author;
    private String description;
    private Difficult difficulty;
    private String category;
    private List<QuestionDTO> questions;
}
