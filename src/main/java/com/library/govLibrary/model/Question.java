package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long questionnaireId;
    private String text;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "questionId", updatable = false)
    private List<Option> option;
}
