package com.EvantageSoft.Loan.Origination.Management.System.service;


import com.EvantageSoft.Loan.Origination.Management.System.DTO.UserRoleDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.Roles;
import com.EvantageSoft.Loan.Origination.Management.System.model.UserRoles;
import com.EvantageSoft.Loan.Origination.Management.System.model.Users;
import com.EvantageSoft.Loan.Origination.Management.System.repository.RolesRepo;
import com.EvantageSoft.Loan.Origination.Management.System.repository.UserRepo;
import com.EvantageSoft.Loan.Origination.Management.System.repository.UserRoleRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepo userRoleRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RolesRepo rolesRepo;

    public List<UserRoles> getAll(){
        return userRoleRepo.findAll();
    }

    public UserRoles getById(Long id){
        return userRoleRepo.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    public UserRoles save(UserRoleDTO dto){
        Users users = userRepo.findById(dto.getUser_id())
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        Roles roles = rolesRepo.findById(dto.getRole_id())
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

        UserRoles userRoles = new UserRoles();
        userRoles.setUsers(users);
        userRoles.setRoles(roles);

        return userRoleRepo.save(userRoles);
    }

    public void delete(Long id){
        userRoleRepo.deleteById(id);
    }
}
