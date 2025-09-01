package com.samlportal.samlportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private long id;
    private String name;
    private String role;
    private String child;
    private String password;
    private String comment;
    private String email;
    private String phone;
    private String department;
    private String semester;
}

