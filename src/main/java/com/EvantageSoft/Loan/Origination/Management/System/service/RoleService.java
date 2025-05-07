package com.EvantageSoft.Loan.Origination.Management.System.service;

import com.EvantageSoft.Loan.Origination.Management.System.model.Roles;
import com.EvantageSoft.Loan.Origination.Management.System.model.Users;
import com.EvantageSoft.Loan.Origination.Management.System.repository.RolesRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RolesRepo rolesRepo;

    public List<Roles> getAllRoles(){
        return rolesRepo.findAll();
    }

    public Roles getRoleById(Long id){
        return rolesRepo.findById(id) .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public Roles createRole(Roles roles){
        return rolesRepo.save(roles);
    }

    public Roles updateRole(Long id, Roles upadtedRole){
        Roles roles = rolesRepo.findById(id).get();
        roles.setName(upadtedRole.getName());
        roles.setDescription(upadtedRole.getDescription());
        return rolesRepo.save(roles);
    };

    public void deleteRole(Long id){
        rolesRepo.deleteById(id);
    }
}
