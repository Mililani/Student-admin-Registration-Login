package com.studentadmin.studentadmin.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentadmin.studentadmin.Model.StudentModel;
import com.studentadmin.studentadmin.Repository.StudRepository;



@Service
public class StudServiceImpl implements StudService{

    @Autowired
    private StudRepository studRepository;
   
   //get all user in a list 
    @Override
    public List<StudentModel> getAllStudent() {
        return studRepository.findAll();
    }


    @Override
    public void saveStudent(StudentModel studentModel) {
        this.studRepository.save(studentModel);
        
    }


    @Override
    public StudentModel getStudentById(Integer id) {
        Optional<StudentModel> optional = studRepository.findById(id);
        StudentModel studentModel= null;
        if(optional.isPresent()) {
            studentModel = optional.get(); 
        }else{

                throw new RuntimeException("User not found"+id);
        }
        return studentModel;
        
    }


    @Override
    public void deleteStudentById(Integer id) {
        this.studRepository.deleteById(id);;
        
    }
    
}
