package com.EvantageSoft.Loan.Origination.Management.System.controller;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.BorrowerDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.Borrower;
import com.EvantageSoft.Loan.Origination.Management.System.service.BorrowerService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    @GetMapping
    public List<Borrower> getAll(){
        return borrowerService.getAll();
    }

    @GetMapping("/{id}")
    public Borrower getById(@PathVariable Long id){
        return borrowerService.getById(id);
    }

    @PostMapping
    public Borrower create(@RequestBody BorrowerDTO dto){
        return borrowerService.create(dto);
    }

    @PutMapping("/{id}")
    public Borrower update(@PathVariable Long id, @RequestBody BorrowerDTO dto){
        return borrowerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        borrowerService.delete(id);
    }
}
