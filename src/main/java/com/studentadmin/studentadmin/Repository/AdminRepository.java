package com.studentadmin.studentadmin.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentadmin.studentadmin.Model.AdminModel;


public interface AdminRepository extends JpaRepository<AdminModel,Integer>{
    
    Optional<AdminModel> findByNameAndPassword(String name,String password);

    Optional<AdminModel> findFirstByName(String name);

}
