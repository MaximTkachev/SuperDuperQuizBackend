package com.hits.superduperquizbackend.DTO.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private String id;
    private String text;
    private Boolean isRight;
}
