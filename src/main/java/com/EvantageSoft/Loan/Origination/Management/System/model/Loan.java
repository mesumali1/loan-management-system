package com.EvantageSoft.Loan.Origination.Management.System.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    @ManyToOne
    @JoinColumn(name = "loan_product_id")
    private LoanProduct loanProduct;

    private BigDecimal principal_amount;
    private BigDecimal interest_rate;
    private Integer tenure_months;
    private LocalDateTime disbursal_date;
    private String status = "Active";
    private Boolean has_co_borrowers = false;
    private Boolean total_liability_split = false;
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
}
