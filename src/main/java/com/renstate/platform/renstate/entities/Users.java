package com.renstate.platform.renstate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age", nullable = false)
    private Long age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "userRank", nullable = false)
    private Long userRank;

    @ElementCollection
    @Column(name = "client_id")
    private List<Integer> listClients;
}
