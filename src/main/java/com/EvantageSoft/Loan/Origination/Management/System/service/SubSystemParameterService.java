package com.EvantageSoft.Loan.Origination.Management.System.service;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.SubSystemParameterDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.SubSystemParameters;
import com.EvantageSoft.Loan.Origination.Management.System.model.SystemParameters;
import com.EvantageSoft.Loan.Origination.Management.System.repository.SubSystemParameterRepo;
import com.EvantageSoft.Loan.Origination.Management.System.repository.SystemParameterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSystemParameterService {

    @Autowired
    SubSystemParameterRepo subSystemRepo;

    @Autowired
    SystemParameterRepo systemParameterRepo;

    public List<SubSystemParameters> getAll(){
        return subSystemRepo.findAll();
    }

    public SubSystemParameters getById(Long id){
        return subSystemRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Subsystem Parameter Not Found."));
    }

    public SubSystemParameters create(SubSystemParameterDTO dto){
        SystemParameters systemParameters = systemParameterRepo.findById(dto.getParameter_id())
                .orElseThrow(()-> new RuntimeException("System Parameter Not Found."));

        SubSystemParameters param = new SubSystemParameters();
        param.setSystemParameters(systemParameters);
        param.setKey(dto.getKey());
        param.setValue(dto.getValue());

        return subSystemRepo.save(param);
    }

    public SubSystemParameters update(Long id, SubSystemParameterDTO dto){
        SubSystemParameters existing = getById(id);
        SystemParameters systemParameters = existing.getSystemParameters();

        existing.setSystemParameters(systemParameters);
        existing.setKey(dto.getKey());
        existing.setValue(dto.getValue());

        return subSystemRepo.save(existing);
    }

    public void delete(Long id){
        subSystemRepo.deleteById(id);
    }
}
