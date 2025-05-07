package com.EvantageSoft.Loan.Origination.Management.System.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @OneToMany(mappedBy = "roles")
    @JsonManagedReference
    private List<UserRoles> userRoles;

    @Column(name = "role_name", unique = true, nullable = false)
    private String name;

    private String description;

    @Column(columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime updated_at = LocalDateTime.now();
}
