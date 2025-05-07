package com.EvantageSoft.Loan.Origination.Management.System.service;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.BorrowerDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.Borrower;
import com.EvantageSoft.Loan.Origination.Management.System.repository.BorrowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {

    @Autowired
    BorrowerRepo borrowerRepo;

    public List<Borrower> getAll(){
        return borrowerRepo.findAll();
    }

    public Borrower getById(Long id){
        return borrowerRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Borrower Not Found"));
    }

    public Borrower create(BorrowerDTO dto){
        Borrower borrower = new Borrower();
        borrower.setBorrower_type(dto.getBorrower_type());
        borrower.setFirst_name(dto.getFirst_name());
        borrower.setLast_name(dto.getLast_name());
        borrower.setBusiness_name(dto.getBusiness_name());
        borrower.setNational_id(dto.getNational_id());
        borrower.setTax_id(dto.getTax_id());
        borrower.setAddress(dto.getAddress());
        borrower.setPhone(dto.getPhone());
        borrower.setEmail(dto.getEmail());

        return borrowerRepo.save(borrower);
    }

    public Borrower update(Long id, BorrowerDTO dto){
        Borrower borrower = getById(id);
        borrower.setBorrower_type(dto.getBorrower_type());
        borrower.setFirst_name(dto.getFirst_name());
        borrower.setLast_name(dto.getLast_name());
        borrower.setBusiness_name(dto.getBusiness_name());
        borrower.setNational_id(dto.getNational_id());
        borrower.setTax_id(dto.getTax_id());
        borrower.setAddress(dto.getAddress());
        borrower.setPhone(dto.getPhone());
        borrower.setEmail(dto.getEmail());
        borrower.setUpdated_at(java.time.LocalDateTime.now());

        return borrowerRepo.save(borrower);
    }

    public void delete(Long id){
        borrowerRepo.deleteById(id);
    }
}
