package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.UserRoleDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.UserRoles;
import com.EvantageSoft.Loan.Origination.Management.System.repository.UserRoleRepo;
import com.EvantageSoft.Loan.Origination.Management.System.service.UserRoleService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRoles")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping
    public List<UserRoles> getAll(){
        return userRoleService.getAll();
    }

    @GetMapping("/{id}")
    public UserRoles getById(@PathVariable Long id){
        return userRoleService.getById(id);
    }

    @PostMapping
    public UserRoles create(@RequestBody UserRoleDTO userRoleDTO){
        return userRoleService.save(userRoleDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userRoleService.delete(id);
    }
}
