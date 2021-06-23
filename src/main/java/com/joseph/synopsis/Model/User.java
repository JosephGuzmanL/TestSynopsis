package com.joseph.synopsis.Model;


import com.sun.istack.NotNull;

import javax.persistence.*;

//Entity created, model a User with fields (id, name, lastName, phone, password)
@Entity
@Table(name="user_table")
public class User {

    @Id
    private Long id;

    @Column(name = "name", length = 50) @NotNull
    private String name;

    @Column(name = "lastname", length = 50) @NotNull
    private String lastname;

    @Column(name="phone", unique = true, length=20) @NotNull
    private Long phone;

    @Column(name="password", length = 256) @NotNull
    private String password;

    public User(Long id, String name, String lastname, Long phone, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.password = password;
    }
    public User() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
