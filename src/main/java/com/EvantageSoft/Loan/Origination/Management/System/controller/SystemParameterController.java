package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.SystemParameterDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.SystemParameters;
import com.EvantageSoft.Loan.Origination.Management.System.service.SystemParameterService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemParameters")
public class SystemParameterController {

    @Autowired
    SystemParameterService parameterService;

    @GetMapping
    public List<SystemParameters> getAll(){
        return parameterService.getAll();
    }

    @GetMapping("/{id}")
    public SystemParameters getById(@PathVariable Long id){
        return parameterService.getById(id);
    }

    @PostMapping
    public SystemParameters create(@RequestBody SystemParameterDTO dto){
        return parameterService.create(dto);
    }

    @PutMapping("/{id}")
    public SystemParameters update(@PathVariable Long id, @RequestBody SystemParameterDTO dto){
        return parameterService.update(id, dto);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        parameterService.delete(id);
    }
}
