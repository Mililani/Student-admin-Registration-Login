package com.studentadmin.studentadmin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentadmin.studentadmin.Model.StudentModel;
import com.studentadmin.studentadmin.Repository.StudentRepository;



@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentModel registerStudent(String name,String email,String Address,String Course,String password){
        if (name == null || password == null) {
            return  null;
        } else {
            if(studentRepository.findFirstByName(name).isPresent()){
                System.out.println("Duplicate Name found");
                return null;
            }
            StudentModel studentModel=new StudentModel();
            studentModel.setName(name);
            studentModel.setEmail(email);
            studentModel.setAddress(Address);
            studentModel.setCourse(Course);
            studentModel.setPassword(password);
            
            return studentRepository.save(studentModel);
        }
    }
    public  StudentModel authenticate(String name,String password){
        return  studentRepository.findByNameAndPassword(name,password).orElse(null);
    }

}
