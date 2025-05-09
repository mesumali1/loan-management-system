package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.LoanDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.Loan;
import com.EvantageSoft.Loan.Origination.Management.System.model.LoanProduct;
import com.EvantageSoft.Loan.Origination.Management.System.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping
    public List<Loan> getAll(){
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public Loan getById(@PathVariable Long id){
        return loanService.getById(id);
    }

    @PostMapping
    public Loan create(@RequestBody LoanDTO dto){
        return loanService.create(dto);
    }

    @PutMapping("/{id}")
    public Loan update(@PathVariable Long id, @RequestBody LoanDTO dto){
        return loanService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        loanService.delete(id);
    }
}
