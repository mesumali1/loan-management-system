package com.EvantageSoft.Loan.Origination.Management.System.DTO;

import lombok.Data;

@Data
public class LoanProductDTO {

    private String product_code;
    private String product_name;
    private String description;
    private Double interest_rate;
    private Integer max_tenure_months;
    private Boolean allow_co_borrowers;
}
