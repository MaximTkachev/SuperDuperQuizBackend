package com.hits.superduperquizbackend.entity;

import lombok.*;

import javax.persistence.*;

//@Data
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;
}
