package com.hits.superduperquizbackend.entity;

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
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @Column
    private String id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private QuizEntity quiz;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AnswerOptionEntity> answerOptions;

    public QuestionEntity(String text, QuizEntity quiz) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.quiz = quiz;
        this.answerOptions = new HashSet<>();
    }
}
