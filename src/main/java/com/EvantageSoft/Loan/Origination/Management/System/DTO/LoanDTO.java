package com.EvantageSoft.Loan.Origination.Management.System.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.time.LocalDateTime;

@Data
public class LoanDTO {

    private Long borrower_id;
    private Long loan_product_id;
    private BigDecimal principal_amount;
    private BigDecimal interest_rate;
    private Integer tenure_months;
    private LocalDateTime disbursal_date;
    private String status;
    private Boolean has_co_borrowers;
    private Boolean total_liability_split;
}
