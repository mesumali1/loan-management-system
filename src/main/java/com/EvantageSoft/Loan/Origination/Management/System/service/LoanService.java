package com.EvantageSoft.Loan.Origination.Management.System.service;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.LoanDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.Borrower;
import com.EvantageSoft.Loan.Origination.Management.System.model.Loan;
import com.EvantageSoft.Loan.Origination.Management.System.model.LoanProduct;
import com.EvantageSoft.Loan.Origination.Management.System.repository.BorrowerRepo;
import com.EvantageSoft.Loan.Origination.Management.System.repository.LoanProductRepo;
import com.EvantageSoft.Loan.Origination.Management.System.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepo loanRepo;
    @Autowired
    LoanProductRepo loanProductRepo;
    @Autowired
    BorrowerRepo borrowerRepo;

    public List<Loan> getAll() {
        return loanRepo.findAll();
    }

    public Loan getById(Long id) {
        return loanRepo.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public Loan create(LoanDTO dto) {
        Borrower borrower = borrowerRepo.findById(dto.getBorrower_id())
                .orElseThrow(() -> new RuntimeException("Borrower not found"));

        LoanProduct lp = loanProductRepo.findById(dto.getLoan_product_id())
                .orElseThrow(() -> new RuntimeException("Loan Product not found"));

        Loan loan = new Loan();
        loan.setBorrower(borrower);
        loan.setLoanProduct(lp);
        loan.setPrincipal_amount(dto.getPrincipal_amount());
        loan.setInterest_rate(dto.getInterest_rate());
        loan.setTenure_months(dto.getTenure_months());
        loan.setDisbursal_date(dto.getDisbursal_date());
        loan.setStatus(dto.getStatus());
        loan.setHas_co_borrowers(dto.getHas_co_borrowers());
        loan.setTotal_liability_split(dto.getTotal_liability_split());
        loan.setCreated_at(LocalDateTime.now());
        loan.setUpdated_at(LocalDateTime.now());

        return loanRepo.save(loan);
    }

    public void delete(Long id) {
        loanRepo.deleteById(id);
    }

    public Loan update(Long id, LoanDTO dto) {
        Loan existing = getById(id);
//
//        Borrower borrower = borrowerRepo.findById(dto.getBorrower_id())
//                .orElseThrow(() -> new RuntimeException("Borrower not found"));
//
//        LoanProduct product = loanProductRepo.findById(dto.getLoan_product_id())
//                .orElseThrow(() -> new RuntimeException("Loan Product not found"));
//
//        existing.setBorrower(borrower);
//        existing.setLoanProduct(product);
        existing.setPrincipal_amount(dto.getPrincipal_amount());
        existing.setInterest_rate(dto.getInterest_rate());
        existing.setTenure_months(dto.getTenure_months());
        existing.setDisbursal_date(dto.getDisbursal_date());
        existing.setStatus(dto.getStatus());
        existing.setHas_co_borrowers(dto.getHas_co_borrowers());
        existing.setTotal_liability_split(dto.getTotal_liability_split());
        existing.setUpdated_at(LocalDateTime.now());

        return loanRepo.save(existing);
    }
}
