package com.hits.superduperquizbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quizzes")
public class QuizEntity {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private Difficult difficult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ResultEntity> results;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<QuestionEntity> questions;

    public QuizEntity(String name, String description, Difficult difficult, UserEntity author, CategoryEntity category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.difficult = difficult;
        this.description = description;
        this.author = author;
        this.category = category;
        this.results = new HashSet<>();
        this.questions = new HashSet<>();
    }
}
