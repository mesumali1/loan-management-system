package com.EvantageSoft.Loan.Origination.Management.System.repository;

import com.EvantageSoft.Loan.Origination.Management.System.model.Loan;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan, Long> {
}
