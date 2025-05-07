package com.EvantageSoft.Loan.Origination.Management.System.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrower_id")
    private Long id;

    @OneToMany(mappedBy = "borrower")
    @JsonManagedReference
    private List<CoBorrower> coBorrower;

    @Column(nullable = false)
    private String borrower_type;

    private String first_name;

    private String last_name;

    private String business_name;

    private String national_id;

    private String tax_id;

    private String address;

    private String phone;

    private String email;

    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime updated_at = LocalDateTime.now();
}
