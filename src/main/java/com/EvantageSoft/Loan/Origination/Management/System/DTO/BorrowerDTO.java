package com.EvantageSoft.Loan.Origination.Management.System.DTO;

import lombok.Data;

@Data
public class BorrowerDTO {

    private String borrower_type;
    private String first_name;
    private String last_name;
    private String business_name;
    private String national_id;
    private String tax_id;
    private String address;
    private String phone;
    private String email;

}
