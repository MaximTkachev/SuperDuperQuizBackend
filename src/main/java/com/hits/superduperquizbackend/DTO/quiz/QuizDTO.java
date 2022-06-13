package com.hits.superduperquizbackend.DTO.quiz;

import com.hits.superduperquizbackend.entity.Difficult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private String id;
    private String name;
    private String description;
    private Difficult difficulty;
    private String category;
}
