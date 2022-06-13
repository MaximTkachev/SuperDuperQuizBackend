package com.hits.superduperquizbackend.DTO.quiz;

import com.hits.superduperquizbackend.entity.Difficult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuizDTO {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Difficult difficulty;

    @NotBlank
    private String category;

    private List<CreateQuestionDTO> questions;
}
