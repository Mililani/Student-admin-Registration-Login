package com.studentadmin.studentadmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentadmin.studentadmin.Model.StudentModel;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <StudentModel,Integer> {
   
    Optional<StudentModel> findByNameAndPassword(String name,String password);

    Optional<StudentModel> findFirstByName(String name);

}
