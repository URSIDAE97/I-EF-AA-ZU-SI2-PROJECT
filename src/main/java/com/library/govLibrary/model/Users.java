package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Timestamp created;
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username")
    private Authorities authority;
}
