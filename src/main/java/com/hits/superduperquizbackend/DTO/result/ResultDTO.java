package com.hits.superduperquizbackend.DTO.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    private String id;
    private String userId;
    private String quizId;
    private Integer score;
}
