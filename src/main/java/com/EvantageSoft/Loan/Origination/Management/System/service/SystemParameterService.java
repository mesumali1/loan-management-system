package com.EvantageSoft.Loan.Origination.Management.System.service;

import com.EvantageSoft.Loan.Origination.Management.System.DTO.SystemParameterDTO;
import com.EvantageSoft.Loan.Origination.Management.System.model.SubSystemParameters;
import com.EvantageSoft.Loan.Origination.Management.System.model.SystemParameters;
import com.EvantageSoft.Loan.Origination.Management.System.repository.SystemParameterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemParameterService {

    @Autowired
    SystemParameterRepo systemParameterRepo;

    public List<SystemParameters> getAll(){
        return systemParameterRepo.findAll();
    }

    public SystemParameters getById(Long id){
        return systemParameterRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("System Parameter Not Found"));
    }

    public SystemParameters create(SystemParameterDTO dto){
        SystemParameters param = new SystemParameters();
        param.setName(dto.getName());
        param.setValue(dto.getValue());
        param.setDescription(dto.getDescription());
        return systemParameterRepo.save(param);
    }

    public SystemParameters update(Long id, SystemParameterDTO dto){
        SystemParameters existing = getById(id);
        existing.setName(dto.getName());
        existing.setValue(dto.getValue());
        existing.setDescription(dto.getDescription());
        return systemParameterRepo.save(existing);
    }

    public void delete(Long id){
        systemParameterRepo.deleteById(id);
    }
}
