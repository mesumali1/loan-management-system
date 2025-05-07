package com.EvantageSoft.Loan.Origination.Management.System.service;

import com.EvantageSoft.Loan.Origination.Management.System.model.Users;
import com.EvantageSoft.Loan.Origination.Management.System.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }

    public Users getUserById(Long id){
        return userRepo.findById(id) .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public Users createUser(Users users){
        return userRepo.save(users);
    }

    public Users updateUser(Long id, Users upadtedUser){
        Users user = userRepo.findById(id).get();
        user.setName(upadtedUser.getName());
        user.setPassword(upadtedUser.getPassword());
        user.setEmail(upadtedUser.getEmail());
        user.setStatus(upadtedUser.getStatus());
        return userRepo.save(user);
        };

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
