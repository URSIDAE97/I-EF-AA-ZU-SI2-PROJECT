package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

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
    @Length(min = 5, max = 80)
    @NotBlank
    private String title;

    @NotNull
    @Length(min = 5, max = 500)
    @NotBlank
    private String description;

    @NotNull
    private LocalDateTime created;
    private LocalDateTime activation;
    private LocalDateTime expired;


    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "questionnaireId", updatable = false, insertable = true)
    private List<Question> question;
}
