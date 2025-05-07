package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.model.Roles;
import com.EvantageSoft.Loan.Origination.Management.System.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class    RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Roles> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Roles getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles roles){
        return roleService.createRole(roles);
    }

    @PutMapping("/{id}")
    public Roles updateRole(@PathVariable Long id, @RequestBody Roles roles){
        return roleService.updateRole(id, roles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Roles> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
