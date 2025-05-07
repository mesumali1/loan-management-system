package com.EvantageSoft.Loan.Origination.Management.System.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @OneToMany(mappedBy = "users")
    @JsonManagedReference
    private List<UserRoles> userRoles;

    @Column(name = "username", unique = true, nullable = false)
    private String name;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String status = "Acive";

    @Column(columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime updated_at = LocalDateTime.now();
}
