package com.hits.superduperquizbackend.DTO.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionDTO {
    private String text;
    private List<CreateAnswerOptionDTO> answers;
}
