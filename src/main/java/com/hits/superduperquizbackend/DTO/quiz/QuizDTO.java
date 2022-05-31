package com.hits.superduperquizbackend.DTO.quiz;

import com.hits.superduperquizbackend.entity.Difficult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private String id;
    private String name;
    private String description;
    private Difficult difficult;
    private String categoryId;
    private Set<String> results;
}
