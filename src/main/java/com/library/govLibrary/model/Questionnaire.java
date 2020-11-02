package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Questionnaire {
    @Id
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
