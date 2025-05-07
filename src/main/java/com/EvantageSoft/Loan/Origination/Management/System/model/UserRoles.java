package com.EvantageSoft.Loan.Origination.Management.System.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;

    private LocalDateTime assigned_at = LocalDateTime.now();
}
