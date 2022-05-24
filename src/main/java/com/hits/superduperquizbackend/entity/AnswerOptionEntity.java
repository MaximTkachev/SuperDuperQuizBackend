package com.hits.superduperquizbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answer_options")
public class AnswerOptionEntity {

    @Id
    @Column
    private String id;

    @Column
    private String text;

    @Column
    private Boolean isRight;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;
}
