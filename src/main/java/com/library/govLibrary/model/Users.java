package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Users {
    @Id
    private String username;
    private String password;
    private boolean enabled;
    private String name;
    private String surname;
    private LocalDateTime created;
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username")
    private Authorities authority;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username", updatable = false, insertable = false)
    private List<Questionnaire> questionnaires;
}
