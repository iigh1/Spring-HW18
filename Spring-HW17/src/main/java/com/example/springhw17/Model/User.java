package com.example.springhw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min=4, max = 10, message = "name length should be more than 4 ")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotEmpty(message = "username cannot be empty")
    @Size(min=4, max = 10, message = "name length should be more than 4 ")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String username;

    @NotNull(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "role cannot be empty")
    @Column(columnDefinition = " varchar(10) not null check(role='admin' or role='user')")
    private String role;

    @NotNull(message = "age cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
