package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String summary;
    @NotNull
    private String description;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCategory", updatable = false, insertable = false)
    private List<Questionnaire> questionnaire;
}
