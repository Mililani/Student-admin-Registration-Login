package com.myproject.myproject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myproject.Model.UsersModel;
import com.myproject.myproject.Repository.StudRepository;


@Service
public class StudServiceImpl implements StudService{

    @Autowired
    private StudRepository studRepository;
   
   //get all user in a list 
    @Override
    public List<UsersModel> getAllUsers() {
        return studRepository.findAll();
    }


    @Override
    public void saveUsers(UsersModel usersModel) {
        this.studRepository.save(usersModel);
        
    }


    @Override
    public UsersModel getUserBiId(Integer id) {
        Optional<UsersModel> optional = studRepository.findById(id);
        UsersModel userModel= null;
        if(optional.isPresent()) {
            userModel = optional.get(); 
        }else{

                throw new RuntimeException("User not found"+id);
        }
        return userModel;
        
    }


    @Override
    public void deleteUserById(Integer id) {
        this.studRepository.deleteById(id);;
        
    }
    
}
