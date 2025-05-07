package com.EvantageSoft.Loan.Origination.Management.System.repository;

import com.EvantageSoft.Loan.Origination.Management.System.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRoles, Long> {
}
