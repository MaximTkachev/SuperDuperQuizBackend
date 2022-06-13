package com.hits.superduperquizbackend.DTO.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAnswerOptionDTO {

    @NotBlank
    private String text;

    @NotNull
    private Boolean isRight;
}
