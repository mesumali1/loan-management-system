package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.CoBorrowerDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.CoBorrower;
import com.EvantageSoft.Loan.Origination.Management.System.service.CoBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coBorrowers")
public class CoBorrowerController {

    @Autowired
    CoBorrowerService coBorrowerService;

    @GetMapping
    public List<CoBorrower> getAll(){
        return coBorrowerService.getAll();
    }

    @GetMapping("/{id}")
    public CoBorrower getById(@PathVariable Long id){
        return  coBorrowerService.getById(id);
    }

    @PostMapping
    public CoBorrower create(@RequestBody CoBorrowerDTO dto){
        return coBorrowerService.create(dto);
    }

    @PutMapping("/{id}")
    public CoBorrower update(@PathVariable Long id, @RequestBody CoBorrowerDTO dto){
        return coBorrowerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        coBorrowerService.delete(id);
    }
}
