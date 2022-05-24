package com.hits.superduperquizbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "results")
public class ResultEntity {
    @Id
    @Column
    private String id;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private QuizEntity quiz;
}
