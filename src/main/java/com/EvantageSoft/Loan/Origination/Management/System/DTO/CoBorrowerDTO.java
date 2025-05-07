package com.EvantageSoft.Loan.Origination.Management.System.DTO;

import lombok.Data;

@Data
public class CoBorrowerDTO {
    private Long borrower_id;

    private String co_borrower_type;

    private String first_name;

    private String last_name;

    private String business_name;

    private String national_id_number;

    private String email;

    private String phone;

    private String address;

    private String relationship_to_borrower;


}
