package com.EvantageSoft.Loan.Origination.Management.System.repository;

import com.EvantageSoft.Loan.Origination.Management.System.model.SystemParameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemParameterRepo extends JpaRepository<SystemParameters, Long> {
}
