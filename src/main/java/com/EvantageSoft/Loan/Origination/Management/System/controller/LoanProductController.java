package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.LoanProductDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.LoanProduct;
import com.EvantageSoft.Loan.Origination.Management.System.service.LoanProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanProducts")
public class LoanProductController {

    @Autowired
    LoanProductService loanProductService;

    @GetMapping
    public List<LoanProduct> getAll(){
        return loanProductService.getAll();
    }

    @GetMapping("/{id}")
    public LoanProduct getById(@PathVariable Long id){
        return loanProductService.getById(id);
    }

    @PostMapping
    public LoanProduct create(@RequestBody LoanProductDTO dto){
        return loanProductService.create(dto);
    }

    @PutMapping("/{id}")
    public LoanProduct update(@PathVariable Long id, @RequestBody LoanProductDTO dto){
        return loanProductService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        loanProductService.delete(id);
    }
}
