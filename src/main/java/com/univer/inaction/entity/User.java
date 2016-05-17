package com.univer.inaction.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    private String name;

    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [name=" + name + "; password=" + password + "; email=" + email + "]";
    }
}
