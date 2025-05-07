package com.EvantageSoft.Loan.Origination.Management.System.repository;

import com.EvantageSoft.Loan.Origination.Management.System.model.CoBorrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoBorrowerRepo extends JpaRepository<CoBorrower, Long> {
}
