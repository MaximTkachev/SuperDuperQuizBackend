package com.hits.superduperquizbackend.DTO.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResultDTO {

    @NotBlank
    private String quizId;

    @Min(value = 0)
    private Integer score;
}
