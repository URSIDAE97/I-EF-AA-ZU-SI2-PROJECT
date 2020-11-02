package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private long idCategory;
    private String username;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime created;
    private LocalDateTime activation;
    private LocalDateTime expired;
}
