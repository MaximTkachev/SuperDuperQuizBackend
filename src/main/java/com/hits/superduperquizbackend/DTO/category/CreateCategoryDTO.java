package com.hits.superduperquizbackend.DTO.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDTO {
    @NotBlank
    private String name;
}
