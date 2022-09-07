package com.myproject.myproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.myproject.Model.UsersModel;

@Repository
public interface StudRepository extends JpaRepository<UsersModel,Integer>{
    
}
