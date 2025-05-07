package com.EvantageSoft.Loan.Origination.Management.System.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Data
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_product_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String product_code;

    private String product_name;

    private String description;

    private Double interest_rate;

    private Integer max_tenure_months;

    private Boolean allow_co_borrowers = false;

    private LocalDateTime creation_date = LocalDateTime.now();

    private LocalDateTime last_modified_date = LocalDateTime.now();
}
