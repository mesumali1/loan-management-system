package com.EvantageSoft.Loan.Origination.Management.System.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data

public class SystemParameters {

    @Id
    @GeneratedValue
    @Column(name = "parameter_id")
    private Long id;

    @OneToMany(mappedBy = "systemParameters")
    @JsonManagedReference
    private List<SubSystemParameters> subSystemParameters;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    private String description;

    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime updated_at = LocalDateTime.now();
}
