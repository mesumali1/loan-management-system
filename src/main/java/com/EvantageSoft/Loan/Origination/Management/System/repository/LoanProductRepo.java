package com.EvantageSoft.Loan.Origination.Management.System.repository;

import com.EvantageSoft.Loan.Origination.Management.System.model.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanProductRepo extends JpaRepository<LoanProduct, Long> {
}
