package com.EvantageSoft.Loan.Origination.Management.System.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CoBorrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_borrower_id")
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    private String co_borrower_type;

    private String first_name;

    private String last_name;

    private String business_name;

    private String national_id_number;

    private String email;

    private String phone;

    private String address;

    private String relationship_to_borrower;

    private LocalDateTime creation_date = LocalDateTime.now();

    private LocalDateTime last_modified_date = LocalDateTime.now();
}
