package com.EvantageSoft.Loan.Origination.Management.System.service;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.LoanProductDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.LoanProduct;
import com.EvantageSoft.Loan.Origination.Management.System.repository.LoanProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanProductService {

    @Autowired
    LoanProductRepo loanProductRepo;

    public List<LoanProduct> getAll(){
        return loanProductRepo.findAll();
    }

    public LoanProduct getById(Long id){
        return loanProductRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Loan Product Not Found"));
    }

    public LoanProduct create(LoanProductDTO dto){
        LoanProduct lp = new LoanProduct();
        lp.setProduct_code(dto.getProduct_code());
        lp.setProduct_name(dto.getProduct_name());
        lp.setDescription(dto.getDescription());
        lp.setInterest_rate(dto.getInterest_rate());
        lp.setMax_tenure_months(dto.getMax_tenure_months());
        lp.setAllow_co_borrowers(dto.getAllow_co_borrowers());

        return loanProductRepo.save(lp);
    }

    public LoanProduct update(Long id, LoanProductDTO dto){
        LoanProduct existing = getById(id);
        existing.setProduct_code(dto.getProduct_code());
        existing.setProduct_name(dto.getProduct_name());
        existing.setDescription(dto.getDescription());
        existing.setInterest_rate(dto.getInterest_rate());
        existing.setMax_tenure_months(dto.getMax_tenure_months());
        existing.setAllow_co_borrowers(dto.getAllow_co_borrowers());
        existing.setLast_modified_date(LocalDateTime.now());

        return loanProductRepo.save(existing);
    }

    public void delete(Long id){
        loanProductRepo.deleteById(id);
    }
}
