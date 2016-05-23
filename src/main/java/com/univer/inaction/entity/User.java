package com.univer.inaction.entity;

import com.univer.inaction.validator.Unique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 3, max = 20)
    @Transient
    private String inputPassword;

    private String password;

    @NotNull
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;

    @NotNull
//    @Unique
    private String name;

    public User() {
    }
}
