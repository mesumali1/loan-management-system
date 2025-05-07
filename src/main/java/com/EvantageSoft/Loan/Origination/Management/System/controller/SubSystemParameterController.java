package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.SubSystemParameterDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.SubSystemParameters;
import com.EvantageSoft.Loan.Origination.Management.System.service.SubSystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subsystemParameters")
public class SubSystemParameterController {

    @Autowired
    SubSystemParameterService subSystemService;

    @GetMapping
    public List<SubSystemParameters> getAll(){
        return subSystemService.getAll();
    }

    @GetMapping("/{id}")
    public SubSystemParameters getById(@PathVariable Long id){
        return subSystemService.getById(id);
    }

    @PostMapping
    public SubSystemParameters create(@RequestBody SubSystemParameterDTO dto){
        return subSystemService.create(dto);
    }

    @PutMapping("/{id}")
    public SubSystemParameters update(@PathVariable Long id, @RequestBody SubSystemParameterDTO dto){
        return subSystemService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        subSystemService.delete(id);
    }
}
