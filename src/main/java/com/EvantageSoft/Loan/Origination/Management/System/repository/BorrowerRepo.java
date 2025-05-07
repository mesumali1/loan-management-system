package com.EvantageSoft.Loan.Origination.Management.System.repository;

import com.EvantageSoft.Loan.Origination.Management.System.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepo extends JpaRepository<Borrower, Long> {
}
