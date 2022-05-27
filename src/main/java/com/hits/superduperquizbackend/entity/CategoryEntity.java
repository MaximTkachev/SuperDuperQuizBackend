package com.hits.superduperquizbackend.entity;

import com.hits.superduperquizbackend.DTO.category.CreateCategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<QuizEntity> quizzes;

    public CategoryEntity(CreateCategoryDTO dto) {
        this.id = UUID.randomUUID().toString();
        this.name = dto.getName();
        this.quizzes = new HashSet<>();
    }
}
