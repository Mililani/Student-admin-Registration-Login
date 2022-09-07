package com.studentadmin.studentadmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentadmin.studentadmin.Model.StudentModel;


@Repository
public interface StudRepository extends JpaRepository<StudentModel,Integer>{
    
}
