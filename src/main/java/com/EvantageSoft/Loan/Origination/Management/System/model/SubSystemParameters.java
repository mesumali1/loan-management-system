package com.EvantageSoft.Loan.Origination.Management.System.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class SubSystemParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_param-id")
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parameter_id")
    private SystemParameters systemParameters;

    private String key;

    private String Value;

    private LocalDateTime created_at = LocalDateTime.now();
}
