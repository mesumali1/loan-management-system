package com.EvantageSoft.Loan.Origination.Management.System.service;


import com.EvantageSoft.Loan.Origination.Management.System.DTO.CoBorrowerDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.Borrower;
import com.EvantageSoft.Loan.Origination.Management.System.model.CoBorrower;
import com.EvantageSoft.Loan.Origination.Management.System.repository.BorrowerRepo;
import com.EvantageSoft.Loan.Origination.Management.System.repository.CoBorrowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoBorrowerService {

    @Autowired
    CoBorrowerRepo coBorrowerRepo;

    @Autowired
    BorrowerRepo borrowerRepo;

    public List<CoBorrower> getAll(){
        return coBorrowerRepo.findAll();
    }

    public CoBorrower getById(Long id){
        return coBorrowerRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Co-Borrower Not Found"));
    }

    public CoBorrower create(CoBorrowerDTO dto){
        Borrower borrower = borrowerRepo.findById(dto.getBorrower_id())
                .orElseThrow(()->new RuntimeException("Borrower Not Found"));

        CoBorrower cb = new CoBorrower();
        cb.setBorrower(borrower);
        cb.setCo_borrower_type(dto.getCo_borrower_type());
        cb.setFirst_name(dto.getFirst_name());
        cb.setLast_name(dto.getLast_name());
        cb.setBusiness_name(dto.getBusiness_name());
        cb.setNational_id_number(dto.getNational_id_number());
        cb.setEmail(dto.getEmail());
        cb.setPhone(dto.getPhone());
        cb.setAddress(dto.getAddress());
        cb.setRelationship_to_borrower(dto.getRelationship_to_borrower());

        return coBorrowerRepo.save(cb);
    }

    public CoBorrower update(Long id, CoBorrowerDTO dto){
        CoBorrower existing = getById(id);
        Borrower borrower = existing.getBorrower();

        existing.setBorrower(borrower);
        existing.setCo_borrower_type(dto.getCo_borrower_type());
        existing.setFirst_name(dto.getFirst_name());
        existing.setLast_name(dto.getLast_name());
        existing.setBusiness_name(dto.getBusiness_name());
        existing.setNational_id_number(dto.getNational_id_number());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setAddress(dto.getAddress());
        existing.setRelationship_to_borrower(dto.getRelationship_to_borrower());
        existing.setLast_modified_date(java.time.LocalDateTime.now());

        return coBorrowerRepo.save(existing);
    }

    public void delete(Long id){
        coBorrowerRepo.deleteById(id);
    }
}
