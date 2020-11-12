package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Option {
    @Id
    private long id;
    @NotEmpty
    @NotNull
    @Length(min = 3)
    private String text;
    private long questionId;
}
