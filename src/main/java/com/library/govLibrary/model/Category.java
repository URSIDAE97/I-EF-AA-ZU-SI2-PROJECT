package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 80)
    private String summary;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 500)
    private String description;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idCategory", updatable = false, insertable = false)
    private List<Questionnaire> questionnaire;
}
